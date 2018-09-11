package com.p2g.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 2016-07-13 18:22.
 *
 * @author FanShukui
 */
public class SerialNumberUtil {
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
        System.out.println(str);
        return str + RandomStringUtils.randomNumeric(9);
    }

    public static void safeSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized String createShortSerial() {
        safeShortSleep(1);
        SimpleDateFormat sdft = new SimpleDateFormat("yyMMddhhmmss");
        Date nowdate = new Date();
        String str = sdft.format(nowdate);
        System.out.println(str);
        return str;
    }

    public static void safeShortSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(createShortSerial());
    }
}
