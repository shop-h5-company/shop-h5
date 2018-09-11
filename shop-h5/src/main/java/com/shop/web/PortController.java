package com.shop.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
  * 解决如：http://localhost:9991/  地址加端口访问时404的问题，改为跳转到首页。
  * @date 2018-4-10 14:29:02
  *
 */
@Controller
@RequestMapping("/")
public class PortController extends MyBaseController {

    public static final String JSP_PATH = "home/";

    @RequestMapping("")
    public String index(HttpServletRequest request,ModelMap modelMap){
        //return JSP_PATH + "index";
    	return "redirect:/home/index"; //重定向到这个控制器
    }
}
