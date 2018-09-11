package com.shop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;

public class AuthUtils {
    /**
     * 创建登录Cookie
     */
    public static Cookie createtCookie(String name, String domain, Integer maxAge, String data) throws Exception {
        if(maxAge == null)
            maxAge = -1;
        Cookie cookie = new Cookie(name, name);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(domain);
        cookie.setPath("/");
        cookie.setValue(data);
        return cookie;
    }


}
