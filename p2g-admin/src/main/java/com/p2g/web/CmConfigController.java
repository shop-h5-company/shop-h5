package com.p2g.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.p2g.mybatis.model.generator.CmConfig;
import com.p2g.service.CmConfigService;
import com.p2g.util.BeanUtil;
import com.p2g.vo.CmConfigDto;

/**
 * Created on 2016-06-21 17:38.
 *
 * @author zhaozizhen
 */
@Controller
@RequestMapping("cmConfig")
public class CmConfigController extends MyBaseController{

    public static final String JSP_PATH = "cmConfig/";

    @Autowired
    CmConfigService cmConfigService;

    @RequestMapping("getList")
    public String getList(ModelMap modelMap,CmConfigDto cmConfig){
        modelMap.putAll(BeanUtil.transBean2Map(cmConfig));
        PageInfo<CmConfig> pageInfo = cmConfigService.query(modelMap);
        modelMap.addAttribute("pageInfo",pageInfo);
        return JSP_PATH+"cm_config_list";
    }
    @RequestMapping("add")
    public String addCmConfig(){
        return "cmConfig/add_cm_config";
    }

    @RequestMapping("addSubmit")
    public Object addCmConfigSubmit(CmConfig cmConfig){

        cmConfig.setCreateTime(new Date());
        cmConfig.setUpdateTime(new Date());
        cmConfigService.update(cmConfig,"CmConfigId");

        return setSuccessAjaxDone("新增业务数据成功",true,"cm_config");
    }
    
    @RequestMapping("editCmConfig")
    public String editCmConfig(@RequestParam(value = "cmConfigId") Integer cmConfigId,ModelMap modelMap){
        CmConfig cmConfig=cmConfigService.queryById(cmConfigId);
        modelMap.addAttribute("cmConfig",cmConfig);
        return "cmConfig/edit_cm_config";
    }
    
    @RequestMapping("editCmConfigSubmit")
    public Object editCmConfigSubmit(CmConfig cmConfig){
    	cmConfig.setUpdateTime(new Date());
        cmConfigService.update(cmConfig,"CmConfigId");
        return setSuccessAjaxDone("编辑业务数据成功",true,"cm_config");
    }
    
    @RequestMapping("deleteCmConfig")
    public Object deleteCmConfig(@RequestParam(value = "cmConfigId") Integer cmConfigId,ModelMap modelMap){
         cmConfigService.delete(cmConfigId);
        return setSuccessAjaxDone("删除业务数据成功",false,"cm_config");
    }
}
