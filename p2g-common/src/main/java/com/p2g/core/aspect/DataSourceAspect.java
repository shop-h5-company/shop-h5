package com.p2g.core.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 切换数据源(不同方法调用不同数据源)
 * 
 * @author FanShukui
 * @version 2016年5月20日 下午3:17:52
 */
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DataSourceAspect {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(* com.p2g.mybatis.*.dao.*.*(..))")
	public void aspect() {
	}

	/**
	 * 配置前置通知,使用在方法aspect()上注册的切入点
	 */
	@Before("aspect()")
	public void before(JoinPoint point) {
		String className = point.getTarget().getClass().getName();
		String method = point.getSignature().getName();
		logger.info(className + "." + method + "(" + StringUtils.join(point.getArgs(), ",") + ")");
		try {
			L: for (String key : ChooseDataSource.METHODTYPE.keySet()) {
				for (String type : ChooseDataSource.METHODTYPE.get(key)) {
					if (method.startsWith(type)) {
						HandleDataSource.putDataSource(key);
						break L;
					}
				}
			}
		} catch (Exception e) {
			logger.error("切换数据源操作：",e);
			HandleDataSource.putDataSource("write");
		}
	}
}
