package com.p2g.core.aspect;

/**
 * 
 * @author FanShukui
 * @version 2016年5月20日 下午3:18:04
 */
public class HandleDataSource {
	// 数据源名称线程池
	private static final ThreadLocal<String> holder = new ThreadLocal<String>();

	public static void putDataSource(String datasource) {
		holder.set(datasource);
	}

	public static String getDataSource() {
		return holder.get();
	}
}
