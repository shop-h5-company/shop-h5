package com.shop.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by GJF on 2016/7/12.
 */
public class StringReplaceUtil {


    /**
     * 根据用户名的不同长度，来进行替换 ，达到保密效果
     *
     * @param userName 用户名
     * @return 替换后的用户名
     */
    public static String userNameReplaceWithStar(String userName) {
        if (StringUtils.isBlank(userName)) {
            return "";
        }
        String name = StringUtils.left(userName, 1);
        return StringUtils.rightPad(name, StringUtils.length(userName), "*");

    }

    /**
     * 实际替换动作
     *
     * @param username username
     * @param regular  正则
     * @return
     */
    private static String replaceAction(String username, String regular) {
        return username.replaceAll(regular, "*");
    }

    /**
     * 身份证号替换，保留前四位和后四位
     *
     * 如果身份证号为空 或者 null ,返回null ；否则，返回替换后的字符串；
     *
     * @param idCard 身份证号
     * @return
     */
    public static String idCardReplaceWithStar(String idCard) {

        if (idCard.isEmpty() || idCard == null) {
            return null;
        } else {
            idCard=idCard.substring(0,4)+"****"+idCard.substring(idCard.length()-4,idCard.length());
            return idCard;
        }
    }

    /**
     * 银行卡替换，保留后四位
     *
     * 如果银行卡号为空 或者 null ,返回null ；否则，返回替换后的字符串；
     *
     * @param bankCard 银行卡号
     * @return
     */
    public static String bankCardReplaceWithStar(String bankCard) {

        if (bankCard.isEmpty() || bankCard == null) {
            return null;
        } else {
            bankCard=bankCard.substring(bankCard.length()-8,bankCard.length());
            return replaceAction(bankCard, "(?<=\\d{0})\\d(?=\\d{4})");
        }
    }

    /**
     * [手机号码] 前三位，后四位，其他隐藏<例子:138******1234>
     *
     * @param num
     * @return
     */
    public static String mobilePhone(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.left(num, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*"), "***"));
    }

    /**
     *  判断是否16-19位数字
     */
    public static boolean isCardNo(String str){
        String regex = "\\d{16,19}";

        return str.matches(regex);
    }


    /**
     * 读取request流
     * @return
     * @author guoyx
     */
    public static String readReqStr(HttpServletRequest request)
    {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try
        {
            reader = new BufferedReader(new InputStreamReader(request
                    .getInputStream(), "utf-8"));
            String line = null;

            while ((line = reader.readLine()) != null)
            {
                sb.append(line);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (null != reader)
                {
                    reader.close();
                }
            } catch (IOException e)
            {

            }
        }
        return sb.toString();
    }

    /**
     * 字符串是否包含特殊字符
     * @param string
     * @return
     */
    public static boolean isConSpeCharacters(String string){
        String str = string.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*","");
        System.out.println(str);
        if(str.length()==0){
            return false;
        }
        return true;
    }

    /**
     * 清除字符串中包含的特殊字符
     * @param string
     * @return
     */
    public static String clearSpeChar(String string){
        if(!isConSpeCharacters(string)) return string;

        StringBuffer buf = new StringBuffer();
        String regex = "[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*";
        for(int i = 0; i< string.length();i++){
            String subStr = string.substring(i,i);
            if(subStr.matches(regex)){
                buf.append(subStr);
            }
        }

        String newStr = buf.toString();
        return newStr;
    }

}
