package com.shop.util;

import com.p2g.core.util.RedisUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xframe.codec.MdUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created on 2016-06-27 18:40.
 *
 * @author FanShukui
 * @Description 关于验证码的工具类
 *
 */
public final class CaptchaUtil {
    private final static Logger logger = LoggerFactory.getLogger(CaptchaUtil.class);

    public static String CAPTCHANAME_PREFIX = "_ccifn_h5_captcha_randomStr_";
    public static String captchaName = "_ccifn_h5_captcha_randomStr_99999";

    private CaptchaUtil(){}

    public static void setCaptchaName(String captchaName) {
        if(StringUtils.isBlank(captchaName)) {
            throw new IllegalArgumentException("captchaName can not be blank.");
        } else {
            CaptchaUtil.captchaName = captchaName;
        }
    }

    /*
     * 随机字符字典
     */
    private static final String[] strArr = new String[]{"2","3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y"};

    private static final Font[] RANDOM_FONT = new Font[]{new Font("nyala", 1, 38), new Font("Arial", 1, 32), new Font("Bell MT", 1, 32), new Font("Credit valley", 1, 34), new Font("Impact", 1, 32), new Font("Monospaced", 1, 40)};

    /*
     * 随机数
     */
    private static Random random = new Random();

    /*
     * 获取6位随机数
     */
    private static String getRandomString()
    {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < 5; i++)
        {
            buffer.append(strArr[random.nextInt(strArr.length)]);
        }
        return buffer.toString();
    }

    /*
     * 获取随机数颜色
     */
    private static Color getRandomColor(int fc, int bc)
    {
        Random random = new Random();
        if(fc > 255) {
            fc = 255;
        }

        if(bc > 255) {
            bc = 255;
        }

        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    /*
     * 返回某颜色的反色
     */
    private static Color getReverseColor(Color c)
    {
        return new Color(255 - c.getRed(), 255 - c.getGreen(),
                255 - c.getBlue());
    }

    public static void outputCaptcha(HttpServletResponse response)
            throws Exception
    {
        outputCaptcha(captchaName,response);
    }

    public static void outputCaptcha(String captchaName,HttpServletResponse response)
            throws Exception
    {

        response.setContentType("image/jpeg");
        int width = 108;
        int height = 40;

        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(getRandomColor(200, 250));
        g.fillRect(0, 0, 108, 40);
        Random random = new Random();
        g.setFont(RANDOM_FONT[random.nextInt(RANDOM_FONT.length)]);

        Color color;
        for(int sRand = 0; sRand < 10; ++sRand) {
            color = getRandomColor(120, 200);
            g.setColor(color);
            g.drawOval(random.nextInt(108), random.nextInt(40), 5 + random.nextInt(10), 5 + random.nextInt(10));
            color = null;
        }

        String var11 = "";

        for(int bs = 0; bs < 4; ++bs) {
            String curve = String.valueOf(strArr[random.nextInt(strArr.length)]);
            var11 = var11 + curve;
            int degree = random.nextInt(28);
            if(bs % 2 == 0) {
                degree *= -1;
            }

            int x = 22 * bs;
            byte y = 21;
            g.rotate(Math.toRadians((double)degree), (double)x, (double)y);
            color = getRandomColor(20, 130);
            g.setColor(color);
            g.drawString(curve, x + 8, y + 10);
            g.rotate(-Math.toRadians((double)degree), (double)x, (double)y);
            color = null;
        }

        RedisUtil.setex(captchaName,300, MdUtils.md5(var11.toUpperCase()));

        g.setColor(getRandomColor(0, 60));
        BasicStroke var12 = new BasicStroke(3.0F);
        g.setStroke(var12);
        QuadCurve2D.Double var13 = new QuadCurve2D.Double(0.0D, (double)(random.nextInt(32) + 4), 54.0D, 20.0D, 108.0D, (double)(random.nextInt(32) + 4));
        g.draw(var13);
        g.dispose();

        // 转成JPEG格式
        ServletOutputStream out = response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(image);
        out.flush();
    }

    public static boolean validate(String userInputCaptcha) {
        if(StringUtils.isBlank(userInputCaptcha)) {
            return false;
        } else {
            try {
                userInputCaptcha = userInputCaptcha.toUpperCase();
                userInputCaptcha = MdUtils.md5(userInputCaptcha);
            }catch (Exception e){

            }
            logger.debug("--CaptchaUtil.validate--captchaName:"+captchaName);
            String dbCode = RedisUtil.get(captchaName);
            logger.debug("--CaptchaUtil.validate--dbCode:"+captchaName);
            boolean result = userInputCaptcha.equals(dbCode);
            if(result) {
                RedisUtil.del(captchaName);
            }

            return result;
        }
    }

    public static boolean validate(String captchaName, String userInputCaptcha) {
        if(StringUtils.isBlank(userInputCaptcha)) {
            return false;
        } else {
            try {
                userInputCaptcha = userInputCaptcha.toUpperCase();
                userInputCaptcha = MdUtils.md5(userInputCaptcha);
            }catch (Exception e){

            }
            logger.debug("--CaptchaUtil.validate--captchaName:"+captchaName);
            String dbCode = RedisUtil.get(captchaName);
            logger.debug("--CaptchaUtil.validate--dbCode:"+captchaName);
            boolean result = userInputCaptcha.equals(dbCode);
            if(result) {
                RedisUtil.del(captchaName);
            }

            return result;
        }
    }
}
