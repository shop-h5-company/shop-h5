package xframe.kit;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 格式校验功能类
 *
 * @author ZhangQiang
 * @version 2008-10-14 16:03:47
 */
public class ValidateKit
{
    /**
     * 匹配正则表达式
     *
     * @param regex 正则表达式
     * @param value 原字符串
     * @return 结果
     */
    public static boolean match(String regex, String value)
    {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(value).find();
    }

    /**
     * 邮政编码
     *
     * @param str 原字符串
     * @return 结果
     */
    public static boolean isPostCode(String str)
    {
        return match("^\\d{6}$", str);
    }

    /**
     * 身份证号码，18位，并经过格式的严谨性校验
     *
     * @param str 原字符串
     * @return 结果
     */
    public static boolean isIdCard(String str)
    {
        boolean flag = false;
        if (match("(^\\d{18}$)|(^\\d{17}[Xx]$)", str))
        {
            String oVerifyBit = str.substring(17);
            String nVerifyBit = getVerifyBit(str.substring(0, 17));
            Calendar cal = Calendar.getInstance();
            int sysYear = cal.get(Calendar.YEAR);
            int year = Integer.parseInt(str.substring(6, 10));
            int month = Integer.parseInt(str.substring(10, 12));
            int day = Integer.parseInt(str.substring(12, 14));
            if (year >= (sysYear - 120) && year <= sysYear && month > 0 && month < 13 && day > 0 && day < 32 &&
                    oVerifyBit.equalsIgnoreCase(nVerifyBit))
            {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 获取18位身份证的校验位
     *
     * @param str 身份证前17位
     * @return 结果
     */
    private static String getVerifyBit(String str)
    {
        int[] WI = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        String[] VI = {"1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2"};

        int[] ai = new int[str.length()];
        for (int i = 0; i < str.length(); i++)
        {
            ai[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        int num = 0;
        for (int i = 0; i < 17; i++)
        {
            num += ai[i] * WI[i];
        }
        int remaining = num % 11;
        return VI[remaining];
    }

    /**
     * 货币
     *
     * @param str 原字符串
     * @return 结果
     */
    public static boolean isMoney(String str)
    {
        String check = "^(\\d+(?:\\.\\d{1,2})?)$";
        return match(check, str);
    }


    /**
     * 邮件地址
     *
     * @param str 原字符串
     * @return 结果
     */
    public static boolean isEmail(String str)
    {
        return match("^[a-zA-Z0-9]+((-|\\.|_)[a-zA-Z0-9]+)*@[a-zA-Z0-9]+((-|\\.|_)[a-zA-Z0-9]+)*\\.[a-zA-Z0-9]+$", str);
    }

    /**
     * 中文
     *
     * @param str 原字符串
     * @return 结果
     */
    public static boolean isChinese(String str)
    {
        return match("^[\u2E80-\u9FFF]+$", str);
    }

    /**
     * 手机号码
     *
     * @param str 原字符串
     * @return 结果
     */
    public static boolean isMobile(String str)
    {
        return match("(^1\\d{10}$)", str);
    }

    /**
     * 网址
     *
     * @param str 原字符串
     * @return 结果
     */
    public static boolean isUrl(String str)
    {
        return match("^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$", str);
    }

    /**
     * IP地址
     *
     * @param str 原字符串
     * @return 结果
     */
    public static boolean isIpV4(String str)
    {
        String regex = "(((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static void main(String[] args)
    {
        String idCard = "585282190001228908";
        boolean flag = isIdCard(idCard);
        if (flag)
        {
            System.out.println("证件格式正确");
        } else
        {
            System.out.println("证件格式错误");
        }
    }

    /**
     * 判断是否是生日
     *
     * @param value 原字符串
     * @return 结果
     */
    public boolean isBirthDay(String value)
    {
        String check = "(\\d{4})(/|-|\\.)(\\d{1,2})(/|-|\\.)(\\d{1,2})$";


        if (match(check, value))
        {
            int year = Integer.parseInt(value.substring(0, 4));
            int month = Integer.parseInt(value.substring(5, 7));
            int day = Integer.parseInt(value.substring(8, 10));


            if (month < 1 || month > 12)
                return false;


            if (day < 1 || day > 31)
                return false;


            if ((month == 4 || month == 6 || month == 9 || month == 11)
                    && day == 31)
                return false;


            if (month == 2)
            {
                boolean isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
                if (day > 29 || (day == 29 && !isleap))
                    return false;
            }
            return true;
        } else
        {
            return false;
        }
    }
}
