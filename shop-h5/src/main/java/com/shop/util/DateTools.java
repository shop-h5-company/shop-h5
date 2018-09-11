package com.shop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by GJF on 2016/8/3.
 */
public class DateTools {

    public static Date toSimpleDate(String dateStr) {
        Date date = new Date();
        if (null != dateStr && !"".equals(dateStr.trim())) {
            SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH");
            SimpleDateFormat formatter2=new SimpleDateFormat("yyyyMMddHH");
            try {
                dateStr=formatter1.format(formatter2.parse(dateStr));
                Date date1 = formatter1.parse(dateStr);
                return date1;
            } catch (ParseException e) {
                return date;
            }
        }
        return date;
    }
}
