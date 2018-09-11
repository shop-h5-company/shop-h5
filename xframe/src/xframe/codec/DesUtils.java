package xframe.codec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;

/**
 * DES算法
 *
 * @author ZhangQiang
 * @version 2014-2-2 10:28:26
 */
public class DesUtils
{
    private static final String alg = "DES";
    private static final String transformation = "DES/CBC/PKCS5Padding";

    /**
     * 加密
     *
     * @param data 源数据
     * @param key  16位长
     * @param iv   16位长
     * @return byte[]
     * @throws Exception
     */
    public static byte[] encode(byte[] data, String key, String iv) throws Exception
    {
        DESKeySpec dks = new DESKeySpec(key.getBytes("utf-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(alg);
        Key secretKey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(transformation);
        IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes("utf-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
        return cipher.doFinal(data);
    }

    /**
     * 解密
     *
     * @param data 源数据
     * @param key  16位长
     * @param iv   16位长
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decode(byte[] data, String key, String iv) throws Exception
    {
        DESKeySpec dks = new DESKeySpec(key.getBytes("utf-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(alg);
        Key secretKey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(transformation);
        IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes("utf-8"));
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
        return cipher.doFinal(data);
    }
}
