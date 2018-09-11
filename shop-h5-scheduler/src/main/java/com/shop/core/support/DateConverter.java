package com.shop.core.support;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 
  * DateConverter
  * String到date转换器
  * @author xujianwei
  * @date 2017年9月20日 下午1:18:04
  *
 */
public class DateConverter implements Converter<String, Date> {

	private static final Logger logger = LoggerFactory.getLogger(DateConverter.class);

	public static final String FORMAT1 = "yyyy-MM-dd HH:mm:ss";

	public static final String FORMAT2 = "yyyy-MM-dd";

	public static final String FORMAT3 = "MM/dd/yyyy HH:mm:ss";

	public static final String FORMAT4 = "MM/dd/yyyy";


	@Override
	public Date convert( String source ) {
		if ( !StringUtils.isEmpty(source) ) {
			try {
				return new SimpleDateFormat(getFormat(source)).parse(source);
			} catch ( Exception e ) {
				logger.error(e.getMessage(), e);
			}
		}
		return null;
	}


	private static String getFormat( String date ) throws Exception {
		String reg1 = "\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}(.\\d{1,3}){0,1}";
		String reg2 = "\\d{4}-\\d{1,2}-\\d{1,2}";
		String reg3 = "\\d{1,2}/\\d{1,2}/\\d{4} \\d{1,2}:\\d{1,2}:\\d{1,2}(.\\d{1,3}){0,1}";
		String reg4 = "\\d{1,2}/\\d{1,2}/\\d{4}";
		if ( Pattern.matches(reg1, date) ) {
			return FORMAT1;
		} else if ( Pattern.matches(reg2, date) ) {
			return FORMAT2;
		} else if ( Pattern.matches(reg3, date) ) {
			return FORMAT3;
		} else if ( Pattern.matches(reg4, date) ) {
			return FORMAT4;
		} else {
			throw new Exception("不支持的日期格式：" + date);
		}
	}
}
