package com.p2g.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.p2g.mybatis.model.generator.CmSmsLog;
import com.p2g.service.CmSmsLogService;
import com.p2g.util.BeanUtil;
import com.p2g.vo.CmSmsLogDto;

/**
 * Created on 2016-06-21 17:38.
 *
 * @author zhaozizhen
 */
@Controller
@RequestMapping("cmSmsLog")
public class CmSmsLogController extends MyBaseController{

    public static final String JSP_PATH = "cmSmsLog/";

    @Autowired
    CmSmsLogService cmSmsLogService;

    @RequestMapping("getList")
    public String getList(ModelMap modelMap,CmSmsLogDto cmSmsLog){
        modelMap.putAll(BeanUtil.transBean2Map(cmSmsLog));
        PageInfo<CmSmsLog> pageInfo = cmSmsLogService.query(modelMap);
        modelMap.addAttribute("pageInfo",pageInfo);
        return JSP_PATH+"cm_sms_log_list";
    }
}
