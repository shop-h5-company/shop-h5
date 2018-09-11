package com.shop.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public class SerialNumber {
    /**
     * 生成业务流水号
     * 时间（14位，年月日时分秒）+系统流水（randomCount位）
     *
     * @return
     */
    public static synchronized String createSerial() {
        safeSleep(1);
        SimpleDateFormat sdft = new SimpleDateFormat("yyMMddhhmmssssss");
        Date nowdate = new Date();
        String str = sdft.format(nowdate);
        return str + RandomStringUtils.randomNumeric(9);
    }

    public static void safeSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取当前时间str，格式yyyyMMddHHmmss
     * @return
     * @author guoyx
     */
    public static String getCurrentDateTimeStr(Date date)
    {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        if (null==date) {
            date=new Date();
        }
        String timeString = dataFormat.format(date);
        return timeString+ RandomStringUtils.randomNumeric(6);
    }
    public static String getCurrentShortDateTimeStr(Date date)
    {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        if (null==date) {
            date=new Date();
        }
        String timeString = dataFormat.format(date);
        return timeString;
    }

    /**
     * 短信验证码（数字）
     * @param num（位数）
     * @return
     */
    public static String getCurrentRandomString()
    {
        String randomString = RandomStringUtils.randomNumeric(4);
        return randomString;
    }
}
