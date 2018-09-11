package xframe.codec;

import javax.crypto.Cipher;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * RSA加密
 *
 * @author : zhangqiang
 * @version : 2014-7-2 18:15
 */
public class RsaUtils
{
    /**
     * 密钥的长度
     */
    private static final int keylen = 1024;

    /**
     * 密钥的长度
     */
    private static final String algorithm = "RSA/ECB/PKCS1Padding";

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * 得到公钥
     *
     * @param key 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public static PublicKey generatePublic(String key) throws Exception
    {
        byte[] keyBytes = Base64.getDecoder().decode(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * 得到公钥，通过modules和exponent
     *
     * @param modulus  16进制数
     * @param exponent 10进制数
     * @return PublicKey
     * @throws Exception
     */
    public static PublicKey generatePublic(String modulus, String exponent) throws Exception
    {
        RSAPublicKeySpec publicSpec = new RSAPublicKeySpec(new BigInteger(modulus, 16), new BigInteger(exponent));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(publicSpec);
    }

    /**
     * 得到私钥
     *
     * @param key 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public static PrivateKey generatePrivate(String key) throws Exception
    {
        byte[] keyBytes = Base64.getDecoder().decode(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 得到私钥，通过modules和exponent
     *
     * @param modulus  16进制数
     * @param exponent 10进制数
     * @return PrivateKey
     * @throws Exception
     */
    public static PrivateKey generatePrivate(String modulus, String exponent) throws Exception
    {
        RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(new BigInteger(modulus, 16), new BigInteger(exponent));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(rsaPrivateKeySpec);
    }

    /**
     * 得到密钥字符串（经过base64编码）
     */
    public static String generateKeyString(Key key) throws Exception
    {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    /**
     * 从PEM文件读取到字符串中
     *
     * @param fileName String 文件名称
     * @return String 字符串内容
     * @throws IOException
     */
    public static String loadKeyString(String fileName) throws IOException
    {
        StringBuilder builder = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(new File(fileName)))
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            for (String line = br.readLine(); line != null; line = br.readLine())
            {
                if ((line.startsWith("-")) && (line.endsWith("-")))
                {
                    continue;
                }

                builder.append(line);
            }
        }
        return builder.toString();
    }

    /**
     * 生成密钥对,密钥长度1024
     *
     * @return KeyPair
     */
    public static KeyPair genKeyPair() throws Exception
    {
        return genKeyPair(keylen);
    }

    /**
     * 生成密钥对
     *
     * @param keylen 密钥长度
     * @return KeyPair
     */
    public static KeyPair genKeyPair(int keylen) throws Exception
    {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(keylen);
        return kpg.generateKeyPair();
    }

    /**
     * 加密，支持超长内容
     *
     * @param key  Key，公钥或者私钥都可，应该使用本类内部生成的
     * @param data 被加密数据，支持超长数据
     * @return 加密后数据
     */
    public static byte[] encode(Key key, byte[] data) throws Exception
    {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0)
        {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK)
            {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else
            {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /**
     * 解密，支持超长内容
     *
     * @param key  Key，公钥或者私钥都可，应该使用本类内部生成的
     * @param data 待加密数据，支持超长数据
     * @return 解密后数据
     */
    public static byte[] decode(Key key, byte[] data) throws Exception
    {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key);

        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0)
        {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK)
            {
                cache = cipher.doFinal(data, offSet, MAX_DECRYPT_BLOCK);
            } else
            {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;

    }

    public static void main(String[] args) throws Exception
    {
//        KeyPair keyPair = RsaUtils.genKeyPair();
//        String pri = RsaUtils.generateKeyString(keyPair.getPrivate());
//        FileUtils.writeStringToFile(new File("d:/pri.key"), pri);
//        String pub = RsaUtils.generateKeyString(keyPair.getPublic());
//        FileUtils.writeStringToFile(new File("d:/pub.key"), pub);

//        String pri = RsaUtils.loadKeyString("d:/private_key.pem");
//        System.out.println(pri);
//        String pub = RsaUtils.loadKeyString("c:/public_key.pem");
//        PrivateKey privateKey = RsaUtils.generatePrivate(pri);
//        PublicKey publicKey = RsaUtils.generatePublic(pub);

//        byte[] b = RsaUtils.encode(privateKey, "aa".getBytes());
//        byte[] aa = RsaUtils.decode(publicKey, b);


//       byte[] sign = P7Utils.genSign(privateKey,"MD5withRSA","a".getBytes("utf-8"));
//      boolean b=   P7Utils.verifySign(sign,"a".getBytes("utf-8"),publicKey,"MD5withRSA");
//        System.out.println(b);
    }

}
