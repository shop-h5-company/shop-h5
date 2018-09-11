package com.p2g.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.p2g.mybatis.model.generator.CmSmsCode;
import com.p2g.service.CmSmsCodeService;
import com.p2g.util.BeanUtil;
import com.p2g.vo.CmSmsCodeDto;

/**
 * Created on 2016-06-21 17:38.
 *
 * @author zhaozizhen
 */
@Controller
@RequestMapping("cmSmsCode")
public class CmSmsCodeController extends MyBaseController{

    public static final String JSP_PATH = "cmSmsCode/";

    @Autowired
    CmSmsCodeService cmSmsCodeService;

    @RequestMapping("getList")
    public String getList(ModelMap modelMap,CmSmsCodeDto cmSmsCode){
        modelMap.putAll(BeanUtil.transBean2Map(cmSmsCode));
        PageInfo<CmSmsCode> pageInfo = cmSmsCodeService.query(modelMap);
        modelMap.addAttribute("pageInfo",pageInfo);
        return JSP_PATH+"cm_sms_code_list";
    }
}
