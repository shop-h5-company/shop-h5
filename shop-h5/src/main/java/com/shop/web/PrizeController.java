package com.shop.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shop.mybatis.model.generator.Prize;
import com.shop.mybatis.model.generator.Prize2;
import com.shop.mybatis.model.generator.Prizeconfig;
import com.shop.mybatis.model.generator.Users;
import com.shop.service.PrizeService;
import com.shop.service.PrizeconfigService;
import com.shop.service.UserService;
import com.shop.vo.PrizeRandom;
import com.shop.vo.ReturnObjectVO;

@Controller
@RequestMapping("/prize")
public class PrizeController extends MyBaseController{
	public static final String JSP_PATH = "prize/";
	
	public static final String JSP_PATH_LUCK = "luck/";
	
    @Autowired
    private PrizeService prizeService;
    
    @Autowired
    private PrizeconfigService prizeconfigService;
    
    @Autowired
    private UserService userService;
    
    //进入添加奖品页面
    @RequestMapping("index")
	public String index() {
		return JSP_PATH + "index";
	}
    
    /**
     * 进入抽奖页面(包括假页面)
     * @param modelMap
     * @return
     */
    @RequestMapping("luck")
    public String luck(ModelMap modelMap) {
    	long id = 1L;
		try {
			id = getMyCurrUser();
		} catch (NullPointerException e) {
			e.printStackTrace();
			//return "redirect:/luck/unLoginIndex";
			return "luck/unLoginIndex";
		}
    	//判断是否是顶级代理商
    	Users users = userService.queryById(id);
    	if(!users.getJurisdiction().equals("7")){ //用户必须填写微信昵称
    		if(users.getUserName().equals("") || users.getUserName() == null){
    			//return "common/303";// 您尚未填写微信昵称，不能抽奖
    			modelMap.put("alert", "noUserName");
    			return "redirect:/home/index";// 您尚未填写微信昵称，不能抽奖.(并跳转到首页，传参?alert=noUserName)
    		}
    	}
    	if(users.getJurisdiction().equals("7")){//如果该用户顶级用户id为null，或者顶级用户id为自身id，则该用户为顶级用户
    		//顶级用户不能抽奖，而是发奖的人。
    	}
    	//Integer personNum = userService.queryBySuperiorId(id); //根据总下线人数得出的积分是总积分。
    	//1一个人10积分，100积分可抽奖一次。
    	modelMap.addAttribute("jifen", users.getCount()); //这个积分，是用户的现有积分
    	
    	//获取当前代理商设置的奖品（获取该用户的顶级用户设置的奖品）
    	List<Prizeconfig> prizeconfig = prizeconfigService.queryAllByTopLevelId(users.getTopLevel());
    	modelMap.addAttribute("prizeconfig", prizeconfig);
    	//展示获奖名单
    	List<Prize> prizes = prizeService.getLastest(20);
    	List<Long> userIds = new ArrayList<Long>();
    	List<Long> topLevelUserIds = new ArrayList<Long>();
    	for(Prize p : prizes){
    		userIds.add(p.getUserId());
    		topLevelUserIds.add(p.getTopLevel());
    	}
    	List<Users> users2 = userService.queryByIds(userIds);
    	List<Users> topLevelUsers2 = userService.queryByIds(topLevelUserIds);
    	//整理中奖数据
    	for(Prize p:prizes){
    		for(Users u:users2){
    			if(p.getUserId().longValue() == u.getUserId().longValue()){
    				p.setUserIdMobile(u.getMobile());
    				break;
    			}
    		}
    		for(Users u:topLevelUsers2){
    			if(p.getTopLevel().longValue() == u.getUserId().longValue()){
    				p.setTopLevelMobile(u.getMobile());
    				break;
    			}
    		}
    		
    	}
    	List<String> fanhuis = new ArrayList<String>();
    	for(Prize p:prizes){
    		String topLevelMobile = p.getTopLevelMobile();
    		String topLevelMobile2= topLevelMobile.substring(0, 3)+"xxxx"+topLevelMobile.substring(7);
    		String userIdMobile = p.getUserIdMobile();
    		String userIdMobile2= userIdMobile.substring(0, 3)+"xxxx"+userIdMobile.substring(7);
    		String fanhui = "代理商："+topLevelMobile2+"下 "+userIdMobile2+"抽到了 "+p.getPrizeName();
    		fanhuis.add(fanhui);
    	}
    	modelMap.addAttribute("fanhuis", fanhuis);
    	return JSP_PATH_LUCK + "index";
    }
    //进入抽奖页面 废弃
    @RequestMapping("luck2")
	public String luck2(ModelMap modelMap) {
    	long id = getMyCurrUser();
		//判断是否是顶级代理商
		Users users = userService.queryById(id);
		//获取当前代理商设置的奖品
		List<Prizeconfig> prizeconfig = prizeconfigService.queryAllByTopLevelId(users.getTopLevel());
		modelMap.addAttribute("prizeconfig", prizeconfig);
		return JSP_PATH_LUCK + "index";
	}
    /*
     * 跳转到中奖纪录页面
     */
    @RequestMapping("drawRecord")
	public String drawRecord(ModelMap modelMap) {
    	
		return JSP_PATH_LUCK + "drawRecord";
	}
    /*
     * 跳转到中奖纪录页面
     */
    @RequestMapping("getPrizeRecord")
    @ResponseBody
    public ReturnObjectVO getPrizeRecord(ModelMap modelMap) {
    	ReturnObjectVO res = ReturnObjectVO.success();
    	Long userId = getMyCurrUser();
    	List<Prize> prizes = prizeService.queryAllByCurrentUserId(userId);
    	List<Prize2> prizes2 = new ArrayList<Prize2>();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	for(Prize p:prizes){
    		Prize2 p2 = new Prize2();
    		p2.setPrizeName(p.getPrizeName());
    		p2.setInPrizeTime(df.format(p.getInPrizeTime()));
    		prizes2.add(p2);
    	}
    	res.put("prizes", prizes2);
    	return res;
    }
    
    
	//进入获奖名单
    /**
		1、那当然只展示当前的顶级代理人下的喽
     *  2、顶级这么看  后面有个派奖
		     下级只能看自己的是否派奖
		     顶级有个按钮  按了就是派奖了
     */
	@RequestMapping("prizeList")
	public String prizeList(ModelMap modelMap, Long currentUserId) {
		//currentUserId为当前点击的用户id
		Long id = getMyCurrUser();
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//顶级代理商他的字段top_level存的是空、并且权限是7
		Users user = userService.queryById(id);
		if(user.getJurisdiction().equals("7")){ //当前用户是顶级代理商
			List<Users> users = userService.queryByTopLevel(id);//查询该顶级代理商下的所有下级
			users.add(user);//加上代理，有时候代理自己也抽奖测试下
			List<Prize> prizes = prizeService.getByTopLevel(id);
			for(Prize p:prizes){ //给返回的集合中，添加用户姓名
				for(Users u:users){
					if(p.getUserId().longValue() == u.getUserId().longValue()){
						p.setUserName(u.getUserName());
						break;
					}
				}
				p.setUserType("1");
				if(p.getInPrizeTime() != null){
					p.setInPrizeTime2(df.format(p.getInPrizeTime()));
				}
				if(p.getPrizeOutTime() != null){
					p.setPrizeOutTime2(df.format(p.getPrizeOutTime()));
				}
			}
			modelMap.addAttribute("prizes", prizes);
		}else{ //普通用户
			List<Users> users = userService.queryByTopLevel(user.getTopLevel());//查询该顶级代理商下的所有下级
			//List<Prize> prizes = prizeService.getByTopLevel(user.getTopLevel());
			List<Prize> prizes = prizeService.getByUserId(user.getUserId());
			for(Prize p:prizes){
				for(Users u:users){
					if(p.getUserId().longValue() == u.getUserId().longValue()){
						p.setUserName(u.getUserName());
						break;
					}
				}
				p.setUserType("0");
				if(p.getInPrizeTime() != null){
					p.setInPrizeTime2(df.format(p.getInPrizeTime()));
				}
				if(p.getPrizeOutTime() != null){
					p.setPrizeOutTime2(df.format(p.getPrizeOutTime()));
				}
			}
			modelMap.addAttribute("prizes", prizes);
			modelMap.put("common", "common");//普通用户
		}
		
		return JSP_PATH + "prize_list";
	}
	//进入获奖名单 废弃
	@RequestMapping("prizeList2")
	public String prizeList2(ModelMap modelMap, Long currentUserId) {
		//currentUserId为当前点击的用户id
		Long id = getMyCurrUser();
		//所有下级用户信息list
		List<Users> userList = userService.querySubordinateIdList(id);
		String level = "当前登陆人微信号";
		int unsettledAmt = 0;
		//while一般用于 不清楚需要循环多少次的情况下
		while(currentUserId != id && currentUserId != null){ //循环条件中直接为TRUE 
			//获得未结算金额
			//查询该代理商是否有下级
			Users user = userService.querySuperiorId(currentUserId);
			String currentUserIdString = "";
			if (user != null) {
				if(currentUserId == id){ //直到符合条件后跳出本循环 否则一直循环下去
					break;
				}
				//获得下级代理商id
				currentUserId = user.getUserId();
				//获取微信名，微信号 拼接
				currentUserIdString = "→"+user.getWxName()+"("+user.getWeixin()+"";
			}
			//拼接当前登陆人微信号→顏無心（顏無心）→双（shuang）字符串
			level = level + currentUserIdString;
		}
		modelMap.addAttribute("level", level);
		modelMap.addAttribute("unsettledAmt", unsettledAmt);
		modelMap.addAttribute("userList", userList);
		return JSP_PATH + "prize_list";
	}
	
	
	//添加奖品 lz  prizeName='+prizeName+'&probability='+probability+'&sort='+sort, 0红包，1实物
	@ResponseBody
	@RequestMapping(value ="addPrize",method=RequestMethod.POST)
	public ReturnObjectVO addPrize(ModelMap modelMap, String prizeName,Integer probability,String sort,String sequence,Integer stockNum) {
		long id = getMyCurrUser();
		Prizeconfig prizeconfig = new Prizeconfig();
		prizeconfig.setPrizeName(prizeName);
		prizeconfig.setProbability(probability);
		prizeconfig.setSort(sort);
		prizeconfig.setTopLevel(id);
		prizeconfig.setSequence(sequence);
		prizeconfig.setStockNum(stockNum);
		prizeconfig.setUpdateTime(new Date());
		ReturnObjectVO res = ReturnObjectVO.success();
		//判断是否是顶级代理商 （只有顶级代理商才可以编辑奖品）
		Users users = userService.queryById(id);
		if (users != null&&users.getJurisdiction().equals("7")) {
			Prizeconfig old = prizeconfigService.queryBy(sequence, id);
			if (old != null && null!=old.getSequence()) {
				prizeconfig.setPrizeId(old.getPrizeId());
				prizeconfigService.updateById(prizeconfig);//根据主键修改的
			}else {
				prizeconfigService.insert(prizeconfig);
			}
			
			res.put("result", true);
			res.put("msg", "操作成功");
		}else{
			res.put("result", false);
			res.put("msg", "操作失败，您没有权限设置奖品");
		}
		return res;
	}
	//添加奖品 废弃
	@RequestMapping("addPrize2")
	public String addPrize2(ModelMap modelMap, Prizeconfig prizeconfig) {
		long id = getMyCurrUser();
		//判断是否是顶级代理商
		Users users = userService.queryById(id);
		if (users != null&&null!=users.getTopLevel()) {
			prizeconfig = prizeconfigService.queryById(prizeconfig.getPrizeId());
			if (prizeconfig != null&&null!=prizeconfig.getSequence()) {
				prizeconfigService.insert(prizeconfig);
			}else {
				prizeconfigService.updateById(prizeconfig);
			}
		}
		return JSP_PATH + "addPrize";
	}
	/**
	 * 
	 * @param id prize表格主键
	 * @return
	 */
	@RequestMapping("sendPrize")
	@ResponseBody
	public ReturnObjectVO sendPrize(ModelMap modelMap, Long id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("prizeOutTime", new Date());
		prizeService.updateById(map);
		ReturnObjectVO res = ReturnObjectVO.success();
		res.put("result", true);
		res.put("msg", "操作成功");
		return res;
	}
	
	//修改奖品 进入修改页面
	@RequestMapping("editPrize")
	public String editPrize(ModelMap modelMap, String sequence) {
		//判断前端传值不被篡改 只传1-8
		/*String regex = "^\\+?[1-8][1-8]*$";
		if (!sequence.equals(regex)) {
			
		}*/
		try {
			long id = getMyCurrUser();
			Prizeconfig prizeconfig=prizeconfigService.queryBy(sequence,id);
			//
			if(null == prizeconfig){
				Prizeconfig temp = new Prizeconfig();
				temp.setTopLevel(id);
				temp.setSequence(sequence);
				prizeconfigService.insert(temp);
				prizeconfig=prizeconfigService.queryBy(sequence,id);
			}
			modelMap.addAttribute("prizeconfig", prizeconfig);
			modelMap.addAttribute("sequence", sequence);
			return JSP_PATH + "prize_set";
		} catch (Exception e) {
			e.printStackTrace();
			return "common/500";
		}
	}
	//修改奖品   废弃
	@RequestMapping("editPrize2")
	public String editPrize2(ModelMap modelMap, String sequence) {
		Long id = getMyCurrUser();
		Prizeconfig prizeconfig = new Prizeconfig();
		Users user = userService.querySuperiorId(id);
		Long topLevel = null;
		if (user != null) {
			topLevel = user.getTopLevel();
		}
		if (topLevel!=null && id.equals(topLevel)) {
			prizeconfig.setSequence(sequence);
			prizeconfig.setTopLevel(topLevel);
			prizeconfig = prizeconfigService.queryById(prizeconfig);
		}
		List<Prizeconfig> prizeconfiglist = prizeconfigService.queryAllByTopLevelId(topLevel);
		modelMap.addAttribute("prizeconfig", prizeconfig);
		modelMap.addAttribute("prizeconfiglist", prizeconfiglist);
		return JSP_PATH + "prize_set";
	}
	/**
	 * 抽奖
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getPrizeInfo")
	public ReturnObjectVO getPrizeInfo() {
		Long id = getMyCurrUser();
		//得到当前用户的顶级代理
		//Users superior = userService.querySuperiorId(id);
		Users curUser = userService.queryById(id);
		if(curUser.getJurisdiction().equals("7")){ //代理测试抽奖
			
		}else{ //用户抽奖
			Users u = userService.queryById(curUser.getTopLevel());
			id = u.getUserId();
		}
		//得到该代理设置的奖品
		List<Prizeconfig> prizeconfigs = prizeconfigService.queryAllByTopLevelId(id);//这时无论如何，id都是顶级代理的
		if(!prizeconfigs.isEmpty()){
			//遍历该集合，如果某个奖品数量<=0，则剔除该奖品
			List<Prizeconfig> prizeconfigs2 = new ArrayList<Prizeconfig>();
			for(Prizeconfig p:prizeconfigs){
				if(p.getStockNum() == null || p.getPrizeName()==null || p.getPrizeName().equals("") || p.getStockNum().intValue() <= 0){
					prizeconfigs2.add(p);
				}
			}
			prizeconfigs.removeAll(prizeconfigs2);
			//开始抽奖
			if(prizeconfigs.isEmpty()){ //奖品为空时
				ReturnObjectVO res = ReturnObjectVO.success();
				res.put("result", false);
				res.put("msg", "尚未设置奖品或奖品数量不足！");
				return res;
			}
			PrizeRandom prizeRandom = new PrizeRandom();
			int selected=prizeRandom.getPrizeIndex(prizeconfigs); 
			Prizeconfig selectedPrizeconfig = prizeconfigs.get(selected); //抽中了这个商品
	        System.out.println("抽中的奖品为："+selectedPrizeconfig.getPrizeName());
			//1、将该奖品的库存减一
	        prizeconfigService.updatePrizeNum(selectedPrizeconfig.getPrizeId());
	        //2、将中奖信息存入到中奖信息表中。
	        Prize prize = new Prize();
	        prize.setPrizeId(selectedPrizeconfig.getPrizeId());
	        prize.setTopLevel(id);
	        prize.setPrizeName(selectedPrizeconfig.getPrizeName());
	        prize.setInPrizeTime(new Date());
	        prize.setSort(selectedPrizeconfig.getSort());
	        prize.setUserId(curUser.getUserId());
	        prize.setOrder(null);
	        prize.setPrizeOutTime(null);
	        prizeService.insertSelective(prize);
	        
	        //抽奖完毕后，再更新积分
			Users user = new Users();
			user.setUserId(curUser.getUserId());
			user.setCount(-100);
			userService.updateCountById(user);//更新当前用户的积分（抽一次奖减100积分）
			Users user2 = userService.queryById(curUser.getUserId());
			ReturnObjectVO res = ReturnObjectVO.success();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("shengyuJifen", user2.getCount());// 总计积分 - 已抽奖次数*每次抽奖消耗的积分
			map.put("prizeName", "er4等奖 手抓饼");
	        
			map.put("sequence", Integer.parseInt(selectedPrizeconfig.getSequence()) - 1); //奖项分8个，这是其索引（具体得到哪个，按照每个奖项设置的概率）。
			map.put("prizeName", selectedPrizeconfig.getPrizeName());
			res.put("result", true);
			res.put("prizeconfig", map);
			return res;
		}else{//代理没有设置奖品
			ReturnObjectVO res = ReturnObjectVO.success();
			res.put("result", false);
			return res;
		}
		
	}
	/**
	 * 为中奖规则页面，返回具体的奖品
	 * @return
	 */
	@RequestMapping("getPrizeInfoForRule")
	@ResponseBody
	public ReturnObjectVO getPrizeInfoForRule() {
		Long id = getMyCurrUser();
		ReturnObjectVO res = ReturnObjectVO.success();
		//得到当前用户
		Users user = userService.queryById(id);
		
		if(user.getJurisdiction().equals("7")){
			
		}else{
			Users top = userService.queryById(user.getTopLevel());
			id=top.getUserId();
		}
		
		//得到该上级设置的奖品
		List<Prizeconfig> prizeconfigs = prizeconfigService.queryAllByTopLevelId(id);
		for(Prizeconfig p:prizeconfigs){
			p.setPrizeName(p.getSequence()+"等奖："+p.getPrizeName());
		}
		res.put("prize", prizeconfigs);
		return res;
	}
	/**
	 * 为中奖规则页面，返回具体的奖品 废弃
	 * @return
	 */
	@RequestMapping("getPrizeInfoForRule2")
	@ResponseBody
	public ReturnObjectVO getPrizeInfoForRule2() {
		Long id = getMyCurrUser();
		ReturnObjectVO res = ReturnObjectVO.success();
		//得到当前用户的上线
		Users superior = userService.querySuperiorId(id);
		//得到该上级设置的奖品
		List<Prizeconfig> prizeconfigs = prizeconfigService.queryAllByTopLevelId(superior.getUserId());
		for(Prizeconfig p:prizeconfigs){
			p.setPrizeName(p.getSequence()+"等奖："+p.getPrizeName());
		}
		res.put("prize", prizeconfigs);
		return res;
	}

}
