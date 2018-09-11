package com.shop.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.shop.mybatis.dao.generator.OrderformRecordMapper;
import com.shop.mybatis.model.generator.Orderform;
import com.shop.mybatis.model.generator.OrderformRecord;
import com.shop.mybatis.model.generator.Users;
import com.shop.service.OrderformService;
import com.shop.service.UserService;
import com.shop.vo.ReturnObjectVO;

@Controller
@RequestMapping("/orderform")
public class OrderformController extends MyBaseController{
	public static final String JSP_PATH = "orderform/";
	
    @Autowired
    private OrderformService orderformService;
    
    @Autowired
    private OrderformRecordMapper orderformRecordMapper;
    
    @Autowired
    private UserService userService;
    
    
    //进入订单首页
    @RequestMapping("index")
	public String index(ModelMap modelMap) {
    	long id = getMyCurrUser();
		//判断是否是仓管
		Users users = userService.queryById(id);
		List<Orderform> orderformList=null;
		//获取当前仓管添加的订单
		if (users != null&&("1".equals(users.getJurisdiction())||"7".equals(users.getJurisdiction()))) {
			orderformList = orderformService.queryAllById(id);
		}
		modelMap.addAttribute("orderformList", orderformList);
		return JSP_PATH + "index";
	}
    
	//进入订单编辑页面
    @RequestMapping("inAddOrder")
	public String inAddOrder(ModelMap modelMap, Long orderId) {
    	Orderform orderform = orderformService.queryById(orderId);
    	modelMap.addAttribute("orderform", orderform);
    	modelMap.addAttribute("orderId", orderId);
		return JSP_PATH + "order_set";
	}
	
	//添加订单
    @ResponseBody
	@RequestMapping("addOrder")
	public String addOrder(ModelMap modelMap, Orderform orderform, Long orderId) {
		ReturnObjectVO res = ReturnObjectVO.success();
		try {
			long id = getMyCurrUser();
			Users users = userService.queryById(id);
			//判断是否是仓管 仓管时1 顶级代理商是0,  7是管理员
			if (users != null&&("1".equals(users.getJurisdiction())||"7".equals(users.getJurisdiction()))) {
				Orderform orderform1 = orderformService.queryById(orderId);
				if (orderform1 == null) {
					orderform.setUserId(users.getUserId());
					orderform.setCreateTime(new Date());
					orderformService.insert(orderform);
				}else {
					orderform.setId(orderId);
					orderform.setUpdateTime(new Date());
					orderformService.updateById(orderform);
				}
			}
		} catch (Exception e) {
			res = ReturnObjectVO.error("编辑失败");
			e.printStackTrace();
		}
		return JSON.toJSONString(res);
	}
    
	//批量添加订单
	@RequestMapping("inOrderUpload")
	public String addOrder(ModelMap modelMap) {
		return JSP_PATH+"order_Upload";
	}
    
    
    
	//上传文件解析 批量新增数据
  	@ResponseBody
  	@RequestMapping("batchUpload")
  	public String batchUploadWft(MultipartFile file) {
  		ReturnObjectVO res = ReturnObjectVO.success();
  		long id = getMyCurrUser();
        // 解析 txt（csv） 格式文件
  		BufferedReader bufferedReader = null;
  		try {
          	List<Orderform> orderformList = new ArrayList<Orderform>();
  			bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(),"gbk"));
  			String line = null;
  			while (StringUtils.isNotBlank(line = bufferedReader.readLine())) {
  				//客户写入英文逗号时，数据会混乱。
  				//文鑫褚欢欢,张小亲,15234352285,山西省晋中市平遥县尹回村元平商店,"汽运BOSS国际 3盒酵素片,2盒饼干",申通快递,3370840000000
  				//文鑫褚欢欢,李小敏,18639200098,河南省鹤壁市淇滨区香江路天润嘉城一号楼一单元902,汽运BOSS国际  3盒酵素，2盒饼干，送1防护,申通快递,3370840000000
  				if(line.contains("陈丽娜王伟利")){
  					System.out.println("line:"+line);
  				}
  				if(line.contains("\"")){
  					int qian = line.indexOf("\"");
  					int hou = line.lastIndexOf("\"");
  					String jiu = line.substring(qian, hou);
  					String xin = jiu.replace(",", "，");
  					line = line.replace(jiu, xin);
  				}
  				if(line.split(",").length < 7){//不足7列 （解决某列中有回车情况）
  					line = line + bufferedReader.readLine();
  				}
  				String[] columns = line.split(",");
  				//String[] columns = line.replaceAll("；",";").replaceAll("，", ";").replaceAll(",", ";").replaceAll(" ", "").replaceAll("	", "").replaceAll("(\r\n|\r|\n|\n\r)", "").split(";");
  				
  				String jy = columns[0];
				if (!jy.equals("寄件人姓名")) {
					Orderform orderform = new Orderform();
					orderform.setAddresser(columns[0]);
					orderform.setAddressee(columns[1]);
	  				orderform.setPhone(columns[2]);
	  				orderform.setShoppingAddress(columns[3]);
	  				orderform.setMerchandise(columns[4]);
	  				orderform.setExpress(columns[5]);
	  				orderform.setNumber(columns[6]);
	  				orderform.setUserId(id);
	  				orderform.setCreateTime(new Date());
	  				orderformList.add(orderform);
				}
  			}
  			orderformService.insertList(orderformList);
  		}catch (Exception e) {
  			res = ReturnObjectVO.error("批量增加订单出错，请从新添加！");
  			logger.error("批量增加订单出错，请从新添加！", e);
  		}
		return JSON.toJSONString(res);
	}
	
	//删除数据
    @ResponseBody
    @RequestMapping("deleteOrder")
	public String deleteOrder(Orderform orderform, Long orderId) {
    	ReturnObjectVO res = ReturnObjectVO.success();
		try {
			long id = getMyCurrUser();
			Users users = userService.queryById(id);
			//判断是否是仓管 仓管时1 顶级代理商是0,  7是管理员
			if (users != null&&("1".equals(users.getJurisdiction())||"7".equals(users.getJurisdiction()))) {
				Orderform orderform1 = orderformService.queryById(orderId);
				if (orderform1 != null) {
					orderform.setUserId(users.getUserId());
					orderform.setCreateTime(new Date());
					orderformService.delete(orderId);
				}else {
					res = ReturnObjectVO.error("删除失败");
				}
			}
		} catch (Exception e) {
			res = ReturnObjectVO.error("删除失败");
			e.printStackTrace();
		}
		return JSON.toJSONString(res);
	}

    
    /**
     * 购买商品的假页面
     * @return
     */
    @RequestMapping("buy")
    public String buy() {
		return JSP_PATH + "buy";
    }
	//进入查询记录页面
	@RequestMapping("inOrder")
	public String inOrder() {
		return JSP_PATH + "inOrder";
	}
	
	//进入查询记录页面
	@RequestMapping("queryOrder")
	public String queryOrder(ModelMap modelMap, String phOrName) {
		List<Orderform> orderformList = orderformService.queryAllByPhOrName(phOrName);
		modelMap.addAttribute("orderformList", orderformList);
		return JSP_PATH + "queryOrder";
	}
	
	
	//进入订单单个页面
    @RequestMapping("orderById")
	public String orderById(ModelMap modelMap, Long orderId) {
		try {
			Orderform orderform = orderformService.queryById(orderId);
			OrderformRecord orderformRecord = new OrderformRecord();
			BeanUtils.copyProperties(orderformRecord, orderform);
			orderformRecord.setCreateTime(new Date());
			orderformRecordMapper.insert(orderformRecord);
			modelMap.addAttribute("orderform", orderform);
		} catch (IllegalAccessException e) {
			logger.error("用户订单查询出错，请联系管理员",e);
		} catch (InvocationTargetException e) {
			logger.error("用户订单查询出错，请联系管理员",e);
		}
		return JSP_PATH + "order_byId";
	}
	

}
