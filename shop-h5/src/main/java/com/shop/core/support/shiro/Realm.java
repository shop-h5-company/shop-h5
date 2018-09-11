package com.shop.core.support.shiro;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageInfo;
import com.p2g.core.util.WebUtil;
import com.shop.mybatis.model.generator.Users;
import com.shop.service.UserService;

/**
 * 
  * Realm
  * 权限检查类
  * @author xujianwei
  * @date 2017年9月20日 下午1:17:37
  *
 */
public class Realm extends AuthorizingRealm {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private UserService userService;

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("countSql", 0);
		params.put("mobile", token.getUsername());
		PageInfo<Users> pageInfo = userService.query(params);
		if (pageInfo.getSize() == 1) {
			Users users = pageInfo.getList().get(0);
			StringBuilder sb = new StringBuilder(100);
			for (int i = 0; i < token.getPassword().length; i++) {
				sb.append(token.getPassword()[i]);
			}
			if (users.getLoginPassword().equals(sb.toString())) {
				//用户序号
				Long userId = users.getUserId();
				WebUtil.saveCurrentUser(userId);
//				saveSession(userId);
				WebUtil.setSession("weixin",users.getWeixin());
				AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(users.getMobile(), users.getLoginPassword(),
						users.getMobile());
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
/*	private void saveSession(Long userId) {
		UserLoginLog record = new UserLoginLog();
		record.setUserId(userId);
		record.setLoginMode("wap");
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		record.setSessionId(session.getId().toString());
		String host = (String) session.getAttribute("HOST");
		record.setIp(StringUtils.isBlank(host) ? session.getHost() : host);
		record.setLoginTime(new Date());
		userLoginLogService.insert(record);
	}*/
}
