package xframe.codec;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import xframe.kit.ConvertKit;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Hmac算法
 *
 * @author ZhangQiang
 * @version 2014-2-24 17:32:39
 */
public class HmacUtils
{
    public static String md5(String data, String key) throws Exception
    {
        return md(data, key, "HmacMD5");
    }

    public static byte[] md5(byte[] data, byte[] key) throws Exception
    {
        return md(data, key, "HmacMD5");
    }

    public static String sha1(String data, String key) throws Exception
    {
        return md(data, key, "HmacSHA1");
    }

    public static byte[] sha1(byte[] data, byte[] key) throws Exception
    {
        return md(data, key, "HmacSHA1");
    }

    public static String sha256(String data, String key) throws Exception
    {
        return md(data, key, "HmacSHA256");
    }

    public static byte[] sha256(byte[] data, byte[] key) throws Exception
    {
        return md(data, key, "HmacSHA256");
    }

    public static String md(String data, String key, String alg) throws Exception
    {
        byte[] btInput = data.getBytes("utf-8");
        byte[] btKey = key.getBytes("utf-8");
        Mac mac = Mac.getInstance(alg);
        SecretKeySpec spec = new SecretKeySpec(btKey, alg);
        mac.init(spec);
        byte[] byteHMAC = mac.doFinal(btInput);
        return ConvertKit.bytes2Hex(byteHMAC);
    }

    public static byte[] md(byte[] data, byte[] key, String alg) throws NoSuchAlgorithmException, InvalidKeyException
    {
        Mac mac = Mac.getInstance(alg);
        SecretKeySpec spec = new SecretKeySpec(key, alg);
        mac.init(spec);
        return mac.doFinal(data);
    }

    public static void main(String[] args) throws Exception
    {
        System.out.println(HmacUtils.md5("ll", "123456"));
        System.out.println(HmacUtils.sha1("ll", "123456"));
        System.out.println(HmacUtils.sha256("ll", "123456"));
    }
}
