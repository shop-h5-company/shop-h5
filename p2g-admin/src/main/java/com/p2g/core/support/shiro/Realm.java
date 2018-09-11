package com.p2g.core.support.shiro;

import com.github.pagehelper.PageInfo;
import com.p2g.mybatis.model.generator.Admin;
import com.p2g.mybatis.model.generator.AdminLoginLog;
import com.p2g.service.AdminLoginLogService;
import com.p2g.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import com.p2g.core.util.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 权限检查类
 * 
 * @author FanShukui
 * @version 2016年5月20日 下午3:44:45
 */
public class Realm extends AuthorizingRealm {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private AdminService adminService;
	@Resource
	private AdminLoginLogService adminLoginLogService;

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("countSql", 0);
		/*params.put("enable", 1);*/
		params.put("account", token.getUsername());
		PageInfo<Admin> pageInfo = adminService.query(params);
		if (pageInfo.getSize() == 1) {
			Admin admin = pageInfo.getList().get(0);
			StringBuilder sb = new StringBuilder(100);
			for (int i = 0; i < token.getPassword().length; i++) {
				sb.append(token.getPassword()[i]);
			}
			if (admin.getPassword().equals(sb.toString())) {
				WebUtil.saveCurrentUser(admin.getAdminId());
				saveSession(admin.getAdminId(),admin.getAdminCode());
				WebUtil.setSession("adminName",admin.getAdminName());
				AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(admin.getAdminCode(), admin.getPassword(),
						admin.getAdminName());
				return authcInfo;
			}
			logger.warn("USER ["+token.getUsername()+"] PASSWORD IS WRONG: "+sb.toString());
			return null;
		} else {
			logger.warn("No user:"+ token.getUsername());
			return null;
		}
	}

	/** 保存登录日志 */
	private void saveSession(Integer adminId,String account) {
		AdminLoginLog record = new AdminLoginLog();
		record.setAdminId(adminId);
		record.setAdminCode(account);
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		record.setSessionId(session.getId().toString());
		String host = (String) session.getAttribute("HOST");
		record.setIp(StringUtils.isBlank(host) ? session.getHost() : host);
		record.setCreateTime(new Date());
		adminLoginLogService.update(record,"AdminLoginLogId");
	}
}
