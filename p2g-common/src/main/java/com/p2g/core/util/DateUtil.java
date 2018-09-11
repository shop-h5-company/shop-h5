package com.p2g.core.util;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 日期操作辅助类
 * 
 * @author ShenHuaJie
 * @version $Id: DateUtil.java, v 0.1 2014年3月28日 上午8:58:11 ShenHuaJie Exp $
 */
public final class DateUtil {
	private DateUtil() {
	}

	static String PATTERN = "yyyy-MM-dd";

	private static Calendar currTime = null;


	/**
	 * 得到当天日期
	 * @return
	 */
	public static String getCurrentTime(){
		return getDayTime("yyyy-MM-dd HH:mm:ss",0);
	}

	/**
	 * 得到当天日期
	 * @param dateFormat(如:yyyy-MM-dd HH:mm:ss)
	 * @return
	 */
	public static String getCurrentTime(String dateFormat){
		return getDayTime(dateFormat,0);
	}

	/**
	 * 得到当前日期前后n小时的某一日期
	 * @param hourNum 1小时前：-1，1小时后：1
	 * @return
	 */
	public static String getDayTimeOfHour(int hourNum){
		return getDayTimeOfHour(null,hourNum);
	}

	/**
	 * 得到当前日期前后n小时的某一日期
	 * @param dateFormat 时间格式(如:yyyy-MM-dd HH:mm:ss)
	 * @param hourNum 1小时前：-1，1小时后：1
	 * @return
	 */
	public static String getDayTimeOfHour(String dateFormat,int hourNum){
		if(StringUtils.isBlank(dateFormat)) dateFormat = "yyyy-MM-dd HH:mm:ss";
		currTime = GregorianCalendar.getInstance();
		DateFormat bdf = new SimpleDateFormat(dateFormat);
		currTime.add(Calendar.HOUR_OF_DAY, hourNum);
		Date date = currTime.getTime();
		String time = bdf.format(date);
		return time;
	}

	/**
	 * 得到当前日期前后几天的某一日期
	 * @param dateFormat 时间格式(如:yyyy-MM-dd HH:mm:ss)
	 * @param dayNum 1天前：-1，1天后：1
	 * @return
	 */
	public static String getDayTime(String dateFormat,int dayNum){
		currTime = GregorianCalendar.getInstance();
		DateFormat bdf = new SimpleDateFormat(dateFormat);
		currTime.add(Calendar.DAY_OF_MONTH, dayNum);
		Date date = currTime.getTime();
		String time = bdf.format(date);
		return time;
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public static final String format(Object date) {
		return format(date, PATTERN);
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static final String format(Object date, String pattern) {
		if (date == null) {
			return null;
		}
		if (pattern == null) {
			return format(date);
		}
		return new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 获取日期
	 * 
	 * @return
	 */
	public static final String getDate() {
		return format(new Date());
	}

	/**
	 * 获取日期时间
	 * 
	 * @return
	 */
	public static final String getDateTime() {
		return format(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取日期
	 * 
	 * @param pattern
	 * @return
	 */
	public static final String getDateTime(String pattern) {
		return format(new Date(), pattern);
	}

	/**
	 * 日期计算
	 * 
	 * @param date
	 * @param field
	 * @param amount
	 * @return
	 */
	public static final Date addDate(Date date, int field, int amount) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	/**
	 * 字符串转换为日期:不支持yyM[M]d[d]格式
	 * 
	 * @param date
	 * @return
	 */
	public static final Date stringToDate(String date) {
		if (date == null) {
			return null;
		}
		String separator = String.valueOf(date.charAt(4));
		String pattern = "yyyyMMdd";
		if (!separator.matches("\\d*")) {
			pattern = "yyyy" + separator + "MM" + separator + "dd";
			if (date.length() < 10) {
				pattern = "yyyy" + separator + "M" + separator + "d";
			}
		} else if (date.length() < 8) {
			pattern = "yyyyMd";
		}
		pattern += " HH:mm:ss.SSS";
		pattern = pattern.substring(0, Math.min(pattern.length(), date.length()));
		try {
			return new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 间隔天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static final Integer getDayBetween(Date startDate, Date endDate) {
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);
		start.set(Calendar.MILLISECOND, 0);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		end.set(Calendar.HOUR_OF_DAY, 0);
		end.set(Calendar.MINUTE, 0);
		end.set(Calendar.SECOND, 0);
		end.set(Calendar.MILLISECOND, 0);

		long n = end.getTimeInMillis() - start.getTimeInMillis();
		return (int) (n / (60 * 60 * 24 * 1000l));
	}

	/**
	 * 间隔月
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static final Integer getMonthBetween(Date startDate, Date endDate) {
		if (startDate == null || endDate == null || !startDate.before(endDate)) {
			return null;
		}
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		int year1 = start.get(Calendar.YEAR);
		int year2 = end.get(Calendar.YEAR);
		int month1 = start.get(Calendar.MONTH);
		int month2 = end.get(Calendar.MONTH);
		int n = (year2 - year1) * 12;
		n = n + month2 - month1;
		return n;
	}

	/**
	 * 间隔月，多一天就多算一个月
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static final Integer getMonthBetweenWithDay(Date startDate, Date endDate) {
		if (startDate == null || endDate == null || !startDate.before(endDate)) {
			return null;
		}
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		int year1 = start.get(Calendar.YEAR);
		int year2 = end.get(Calendar.YEAR);
		int month1 = start.get(Calendar.MONTH);
		int month2 = end.get(Calendar.MONTH);
		int n = (year2 - year1) * 12;
		n = n + month2 - month1;
		int day1 = start.get(Calendar.DAY_OF_MONTH);
		int day2 = end.get(Calendar.DAY_OF_MONTH);
		if (day1 <= day2) {
			n++;
		}
		return n;
	}

	/**
	 * 取得某一天的前后几天的某一日期
	 * @param time
	 * @param dateFormat
	 * @param dayNum
	 * @return
	 */
	public static String getAfterTimeOfOneDay(String time,String dateFormat,int dayNum){
		DateFormat df = new SimpleDateFormat(dateFormat);
		Date dt;
		try {
			dt = df.parse(time);
			Calendar   calendar=Calendar.getInstance();
			calendar.setTime(dt);
			calendar.add(Calendar.DAY_OF_MONTH, dayNum);
			Date date = calendar.getTime();
			String res = df.format(date);
			return res;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将String型日期转成date
	 * @param date
	 * @param format 日期格式,yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date changeDate(String date,String format)
	{
		if(StringUtils.isBlank(format))
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat df=new SimpleDateFormat(format);
		try {
			return df.parse(date);
		} catch (ParseException e) {
		}
		return null;
	}

	public static Date changeDate(String date)
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return df.parse(date);
		} catch (ParseException e) {
		}
		return null;
	}

	/**
	 * 计算两个日期相差天数
	 * @param startDate 开始日期，格式为yyyyMMdd，不能有时分秒
	 * @param endDate
	 * @return
	 */
	public static long dateMinus(Date startDate,Date endDate)
	{
		return (endDate.getTime()-startDate.getTime())/(24*60*60*1000);
	}
	/**
	 * 计算日期加指定天数后所得日期
	 * @param date 原始日期
	 * @param day 所加天数（负数时为减）
	 * @return
	 */
	public static Date sumDate(Date date,int day)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
//		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));// 今天的日期
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);// 让日期加1
//		System.out.println(calendar.get(Calendar.DATE));// 加1之后的日期Top
		return calendar.getTime();
	}
	/**
	 * 计算日期减指定天数后所得日期
	 * @param date 原始日期
	 * @param day 所加天数（负数时为减）
	 * @return
	 */
	public static Date subDate(Date date,int day)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - day);// 让日期加1
		return calendar.getTime();
	}

	/**
	 * 获取前n个月,返回年月
	 * @param date
	 * @return
	 */
	public static String getPreviousMonth(Date date,int num)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - num);// 让日期加1
		SimpleDateFormat df=new SimpleDateFormat("yyyyMM");
		return df.format(calendar.getTime());
	}

	/**
	 * 获取后一个月,返回年月
	 * @param date
	 * @return
	 */
	public static String getAfterMonth(Date date,int i)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + i);// 让日期加1
		SimpleDateFormat df=new SimpleDateFormat("yyyyMM");
		return df.format(calendar.getTime());
	}

	/**
	 * 获取前后几个月,返回年月
	 * @param date
	 * @param i
	 * @param format
	 * @return
	 */
	public static String getMonth(Date date,int i,String format)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + i);// 让日期加1
		SimpleDateFormat df=new SimpleDateFormat(format);
		return df.format(calendar.getTime());
	}

	/**
	 * 获取指定月天数
	 * @param month yyyyMM
	 * @return
	 */
	public static int getMonthDays(String month){


		Calendar   cal   =   new GregorianCalendar();
		//或者用Calendar   cal   =   Calendar.getInstance();

		/**设置date**/
		SimpleDateFormat oSdf = new SimpleDateFormat ("yyyyMM");
		try {
			cal.setTime(oSdf.parse(month));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		/**开始用的这个方法获取实际月的最大天数**/
		int num2 = cal.getActualMaximum(Calendar.DAY_OF_MONTH);



		return num2;
	}
	/**
	 * 获取下一个月的今天
	 * @param date
	 * @return
	 */
	public static Date getPreviousMonthToday(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);// 让日期加1
		return calendar.getTime();
	}

	/**
	 * 获取指定年有多少周
	 * @param year
	 * @return
	 */
	public static int getTheWeek(int year){
		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		int weeks = c.get(Calendar.WEEK_OF_YEAR);//一年的总周数
		return weeks ;
	}

	/**
	 * 获取指定周的第一天
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date theWeekFirstDay(int year,int week){

		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.WEEK_OF_YEAR,week);
		c.set(Calendar.DAY_OF_WEEK, 1);
		Date weekstart = c.getTime();
		return weekstart ;
	}
	/**
	 * 获取指定周的最后一天
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date theWeekLastDay(int year,int week){

		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.WEEK_OF_YEAR,week);
		c.set(Calendar.DAY_OF_WEEK, 7);
		Date weekend = c.getTime();
		return weekend ;
	}

	/**
	 * 获取指定月份的最后一天是几号
	 * @param year
	 * @param month
	 * @return
	 */
	public static int theMonthLastDay(int year,int month){

		Calendar cal = new GregorianCalendar();
		//年
		cal.set(Calendar.YEAR, year);
		//月，因为Calendar里的月是从0开始，所以要-1
		cal.set(Calendar.MONTH, month - 1);
		//日，设为一号
		cal.set(Calendar.DATE, 1);
		//月份加一，得到下个月的一号
		cal.add(Calendar.MONTH,1);
		//下一个月减一为本月最后一天
		cal.add(Calendar.DATE, -1);
		int monthEnd = cal.get(Calendar.DAY_OF_MONTH);
		return monthEnd;
	}

	/**
	 * 获取指定月份的最后一天
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date theMonthLastDay(String year,String month){
		Calendar cal = new GregorianCalendar();
		//年
		cal.set(Calendar.YEAR, Integer.valueOf(year));
		//月，因为Calendar里的月是从0开始，所以要-1
		cal.set(Calendar.MONTH, Integer.valueOf(month)-1);
		//日，设为一号
		cal.set(Calendar.DATE, 1);
		//月份加一，得到下个月的一号
		cal.add(Calendar.MONTH,1);
		//下一个月减一为本月最后一天
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 获取指定月份的最后一天
	 * @param dateFormat
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getMonthLastDay(String dateFormat,String year,String month){
		Date date = theMonthLastDay(year, month);
		DateFormat bdf = new SimpleDateFormat(dateFormat);
		return bdf.format(date);
	}

	/**
	 * 获取指定年月的第一天
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date theMonthFirstDay(String year,String month){
		Calendar cal = new GregorianCalendar();
		//年
		cal.set(Calendar.YEAR, Integer.valueOf(year));
		//月，因为Calendar里的月是从0开始，所以要-1
		cal.set(Calendar.MONTH, Integer.valueOf(month)-1);
		//日，设为一号
		cal.set(Calendar.DATE, 1);
		return cal.getTime();
	}
	/**
	 * 获取指定日期为该年的第几周
	 * @param date
	 * @return
	 */
	public static int getWeekOfYear(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		c.setTime (date);

		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 得到某一年周的总数
	 *
	 * @param year
	 * @return
	 */
	public static int getMaxWeekNumOfYear(int year) {
		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

		return getWeekOfYear(c.getTime());
	}

	/**
	 * 得到某年某周的第一天
	 *
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getFirstDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set (Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);

		return getFirstDayOfWeek(cal.getTime ());
	}

	/**
	 * 得到某年某周的最后一天
	 *
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getLastDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE , week * 7);

		return getLastDayOfWeek(cal.getTime());
	}

	/**
	 * 取得当前日期所在周的第一天
	 *
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		return c.getTime ();
	}

	/**
	 * 取得当前日期所在周的最后一天
	 *
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return c.getTime();
	}

	/**
	 * 验证当前日期是否在有效期内
	 * 日期格式为 yyyy-MM-dd
	 * 2012-11-22
	 */
	public static boolean verifyAvailable(String begin, String end){
		boolean flag = false;
		if(StringUtils.isBlank(begin) || StringUtils.isBlank(end)) return flag;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		try{
			Date beginTime = sdf.parse(begin);
			Date endTime = sdf.parse(getAfterTimeOfOneDay(end,"yyyy-MM-dd",1));
			Date nowTime = new Date();
			if(nowTime.after(beginTime) && nowTime.before(endTime)) flag = true;
		}catch (Exception e) {

		}
		return flag;
	}

	public static void main(String[] args) {
		System.out.println(DateUtil.theMonthLastDay("2016","6"));

		System.out.println(DateUtil.getMonth(new Date(), 1,"yyyy-MM")+"-01");

	}

}
