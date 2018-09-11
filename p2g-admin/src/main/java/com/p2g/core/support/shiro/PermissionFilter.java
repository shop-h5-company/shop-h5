package com.p2g.core.support.shiro;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.p2g.core.support.HttpCode;
import com.p2g.core.util.WebUtil;

/**
 * URL权限过滤
 * 
 * @author FanShukui
 * @version 2016年5月20日 下午3:44:45
 */
public class PermissionFilter extends PermissionsAuthorizationFilter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PermissionService permissionService;

	@Value("#{configProperties['admin.permission.flag']}")
	private Boolean permissionFlag;

	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws IOException {
		String url = ((HttpServletRequest) request).getServletPath();
		Integer adminId = (Integer) WebUtil.getCurrentUser();
		if (adminId == null) {
			return false;
		}

		if(permissionFlag) {
			if(adminId == 1) return true;
			if (url.startsWith("/home") || permissionService.doCheckPermissionByAdminId(adminId, url)) {
				return true;
			}
			logger.warn("[{}]{}:{}", adminId, HttpCode.FORBIDDEN.msg(), url);
			return false;
		}

		return true;
	}
}
