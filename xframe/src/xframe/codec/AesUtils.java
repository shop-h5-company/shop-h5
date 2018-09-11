package xframe.codec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES算法
 *
 * @author ZhangQiang
 * @version 2014-2-2 10:28:26
 */
public class AesUtils
{
    private static final String alg = "AES";
    private static final String transformation = "AES/CBC/NoPadding";

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
        Cipher cipher = Cipher.getInstance(transformation);
        int blockSize = cipher.getBlockSize();
        int plaintextLength = data.length;
        if (plaintextLength % blockSize != 0)
        {
            plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
        }
        byte[] plaintext = new byte[plaintextLength];
        System.arraycopy(data, 0, plaintext, 0, data.length);
        SecretKeySpec keyspec = new SecretKeySpec(key.getBytes("utf-8"), alg);
        IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes("utf-8"));
        cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
        return cipher.doFinal(plaintext);
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
        Cipher cipher = Cipher.getInstance(transformation);
        SecretKeySpec keyspec = new SecretKeySpec(key.getBytes("utf-8"), alg);
        IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes("utf-8"));
        cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
        return cipher.doFinal(data);
    }
}
