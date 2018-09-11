package com.p2g.core.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * @author user
 * @version $Id: PropertiesUtil.java, v 0.1 2014年3月24日 上午9:08:18 user Exp $
 */
public final class PropertiesUtil {
	private static final Logger log = LoggerFactory.getLogger(PropertiesUtil.class);
	private Properties objProperties;

	/**
	 * 构造函数
	 * 
	 * @param is 属性文件输入流
	 * @throws Exception
	 */
	public PropertiesUtil(InputStream is) throws Exception {
		try {
			objProperties = new Properties();
			objProperties.load(is);
		} catch (FileNotFoundException e) {
			log.error("未找到属性资源文件!", e);
			throw e;
		} catch (Exception e) {
			log.error("读取属性资源文件发生未知错误!", e);
			throw e;
		} finally {
			is.close();
		}
	}

	/**
	 * 持久化属性文件<br>
	 * 使用setProperty()设置属性后,必须调用此方法才能将属性持久化到属性文件中
	 * 
	 * @param pFileName 属性文件名(无后缀名)
	 * @throws IOException
	 */
	public void storefile(String pFileName) {
		FileOutputStream outStream = null;
		try {
			File file = new File(pFileName + ".properties");
			outStream = new FileOutputStream(file);
			objProperties.store(outStream, "#iBase4J");
		} catch (Exception e) {
			log.error("保存属性文件出错.", e);
		} finally {
			try {
				outStream.close();
			} catch (IOException e) {
			}
		}

	}

	/**
	 * 获取属性值
	 * 
	 * @param key 指定Key值，获取value
	 * @return String 返回属性值
	 */
	public String getValue(String key) {
		return objProperties.getProperty(key);
	}

	/**
	 * 获取属性值,支持缺省设置
	 * 
	 * @param key
	 * @param defaultValue 缺省值
	 * @return String 返回属性值
	 */
	public String getValue(String key, String defaultValue) {
		return objProperties.getProperty(key, defaultValue);
	}

	/**
	 * 删除属性
	 * 
	 * @param key 属性Key
	 */
	public void removeProperty(String key) {
		objProperties.remove(key);
	}

	/**
	 * 设置属性
	 * 
	 * @param key 属性Key
	 * @param value 属性值
	 */
	public void setProperty(String key, String value) {
		objProperties.setProperty(key, value);
	}

	/**
	 * 打印所有属性值
	 */
	public void printAllVlue() {
		objProperties.list(System.out);
	}
}
