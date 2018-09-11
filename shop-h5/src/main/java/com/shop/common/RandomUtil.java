package com.shop.common;

import org.apache.commons.text.RandomStringGenerator;

/**
 * 
 * <p>
 *	随机字符串生成操作工具类
 * </p>
 *
 * @author XuJianwei
 * @date 2017年9月26日
 */
public final class RandomUtil {
	private RandomUtil() {
	}
	
	/**
	 * 
	 * 随机生成指定位数的数字字符串
	 * @param length 字符串长度
	 * @return
	 */
	public static final String generateRandomNum(int length){
		 // Generates a 20 code point string, using only the letters a-z
		 RandomStringGenerator generator = new RandomStringGenerator.Builder()
		     .withinRange('0', '9').build();
		 String randomLetters = generator.generate(length);
		 return randomLetters;
	}
	
	/**
	 * 
	 * 随机生成指定位数的字母字符串
	 * @param length 字符串长度
	 * @return
	 */
	public static final String generateRandomABC(int length){
		// Generates a 20 code point string, using only the letters a-z
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
		.withinRange('a', 'z').build();
		String randomLetters = generator.generate(length);
		return randomLetters;
	}
	
	/**
	 * 
	 * 随机生成指定位数的混合字符串
	 * @param length 字符串长度
	 * @return
	 */
	public static final String generateRandomStr(int length){
		// Generates a 20 code point string, using only the letters a-z
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
		.withinRange('0', 'z').build();
		String randomLetters = generator.generate(length);
		return randomLetters;
	}
	
	public static void main(String[] args) {
		System.out.println(generateRandomNum(8));
		System.out.println(generateRandomABC(8));
		System.out.println(generateRandomStr(8));
	}
}
