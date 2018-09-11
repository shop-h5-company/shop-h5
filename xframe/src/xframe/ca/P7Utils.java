package xframe.ca;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.X509Certificate;

/**
 * 证书签名P7功能类
 *
 * @author ZhangQiang
 * @version 2010-2-10 11:42:56
 */
public class P7Utils
{
    /**
     * 签名
     *
     * @param privateKey      私钥
     * @param x509Certificate 证书
     * @param data            原文
     * @return byte[]
     * @throws Exception 异常
     */
    public static byte[] genSign(PrivateKey privateKey, X509Certificate x509Certificate, byte[] data) throws Exception
    {
        return genSign(privateKey, x509Certificate.getSigAlgName(), data);
    }

    /**
     * 签名
     *
     * @param privateKey 私钥
     * @param sigAlgName 算法名称 MD5withRSA
     * @param data       原文
     * @return byte[]
     * @throws Exception 异常
     */
    public static byte[] genSign(PrivateKey privateKey, String sigAlgName, byte[] data) throws Exception
    {
        Signature sign = Signature.getInstance(sigAlgName);
        sign.initSign(privateKey);
        sign.update(data);
        return sign.sign();
    }

    /**
     * 验证签名
     *
     * @param sign            签名数据
     * @param data            原文
     * @param x509Certificate 证书
     * @return boolean
     * @throws Exception 异常
     */
    public static boolean verifySign(byte[] sign, byte[] data, X509Certificate x509Certificate) throws Exception
    {
        return verifySign(sign, data, x509Certificate.getPublicKey(), x509Certificate.getSigAlgName());
    }

    /**
     * 验证签名
     *
     * @param sign       签名数据
     * @param data       原文
     * @param publicKey  公钥
     * @param sigAlgName 签名算法 MD5withRSA
     * @return boolean
     * @throws Exception 异常
     */
    public static boolean verifySign(byte[] sign, byte[] data, PublicKey publicKey, String sigAlgName) throws Exception
    {
        Signature verify = Signature.getInstance(sigAlgName);
        verify.initVerify(publicKey);
        verify.update(data);
        return verify.verify(sign);
    }
}
