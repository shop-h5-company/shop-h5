/**
 * 
 */
package com.p2g.core.config;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.p2g.core.Constants;
import com.p2g.core.support.exception.BusinessException;

/**
 * Redis缓存配置
 * 
 * @author FanShukui
 * @version 2016年5月20日 下午3:18:41
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			/** 重写生成key方法 */
			public Object generate(Object o, Method method, Object... objects) {
				String cacheNamespace = Resources.constants.getString(Constants.CACHE_DB_NAMESPACE);
				StringBuilder sb = new StringBuilder(cacheNamespace);
				CacheConfig cacheConfig = o.getClass().getAnnotation(CacheConfig.class);
				Cacheable cacheable = method.getAnnotation(Cacheable.class);
				CachePut cachePut = method.getAnnotation(CachePut.class);
				CacheEvict cacheEvict = method.getAnnotation(CacheEvict.class);
				if (cacheable != null) {
					String[] cacheNames = cacheable.value();
					if (cacheNames != null && cacheNames.length > 0) {
						sb.append(cacheNames[0]);
					}
				} else if (cachePut != null) {
					String[] cacheNames = cachePut.value();
					if (cacheNames != null && cacheNames.length > 0) {
						sb.append(cacheNames[0]);
					}
				} else if (cacheEvict != null) {
					String[] cacheNames = cacheEvict.value();
					if (cacheNames != null && cacheNames.length > 0) {
						sb.append(cacheNames[0]);
					}
				}
				if (cacheConfig != null && sb.toString().equals(cacheNamespace)) {
					String[] cacheNames = cacheConfig.cacheNames();
					if (cacheNames != null && cacheNames.length > 0) {
						sb.append(cacheNames[0]);
					}
				}
				if (sb.toString().equals(cacheNamespace)) {
					sb.append(o.getClass().getName());
				}
				if (objects != null) {
					sb.append(":");
					if (objects.length == 2) {
						if (objects[0] instanceof Integer || objects[0] instanceof Long || objects[0] instanceof String) {
							sb.append(objects[0]);
						} else {
							try {
								String idName = objects[1].toString();
								String idMethod = "get"+idName;
								sb.append(objects[0].getClass().getMethod(idMethod).invoke(objects[0]));
							} catch (Exception e) {
								throw new BusinessException("Not support.");
							}
						}
					} else if (objects.length == 1) {
						if (objects[0] instanceof Integer || objects[0] instanceof Long || objects[0] instanceof String) {
							sb.append(objects[0]);
						} else {
							try {
								sb.append(objects[0].getClass().getMethod("getId").invoke(objects[0]));
							} catch (Exception e) {
								throw new BusinessException("Not support.");
							}
						}
					} else {
						sb.append(StringUtils.join(objects, ","));
					}
				}
				return sb.toString();
			}
		};
	}
}
