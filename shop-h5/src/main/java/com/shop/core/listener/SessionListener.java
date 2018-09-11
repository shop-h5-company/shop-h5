package com.shop.core.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p2g.core.Constants;
import com.p2g.core.config.Resources;
import com.p2g.core.util.RedisUtil;

/**
 * 会话监听器
 *
 * @author XuJianwei
 *
 */
public class SessionListener implements HttpSessionListener {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http
	 * .HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		session.setAttribute(Resources.constants.getString(Constants.WEBTHEME), "p2g-h5");
		logger.info("创建了一个Session连接:[" + session.getId() + "]");
		setAllUserNumber(1);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet
	 * .http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		if (getAllUserNumber() > 0) {
			logger.info("销毁了一个Session连接:[" + session.getId() + "]");
		}
		session.removeAttribute(Resources.constants.getString(Constants.CURRENT_USER));
//		adminLoginLogService.deleteBySessionId(session.getId());
		setAllUserNumber(-1);
	}

	private void setAllUserNumber(int n) {
		Long number = getAllUserNumber() + n;
		if (number >= 0) {
			logger.info("用户数：" + number);
			RedisUtil.set(Resources.constants.getString(Constants.ALLUSER_NUMBER), 60 * 60 * 24, number);
		}
	}

	/** 获取在线用户数量 */
	public static Long getAllUserNumber() {
		String v = RedisUtil.get(Resources.constants.getString(Constants.ALLUSER_NUMBER));
		if (v != null) {
			return Long.valueOf(v);
		}
		return 0L;
	}
}
