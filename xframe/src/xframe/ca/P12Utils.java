package xframe.ca;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * 私钥证书P12操作类，即.pfx文件
 *
 * @author ZhangQiang
 * @version 2010-2-10 11:40:57
 */
public class P12Utils
{
    /**
     * 合成P12数据
     *
     * @param privateKey 私钥
     * @param cert       证书
     * @param alias      别名
     * @param password   密码
     * @return 数据
     * @throws Exception 异常
     */
    public static byte[] createP12Cert(PrivateKey privateKey, X509Certificate cert, String alias, String password) throws Exception
    {
        ByteArrayOutputStream outputStream = null;
        try
        {
            X509Certificate[] certs = {cert};
            KeyStore store = KeyStore.getInstance("PKCS12");
            store.load(null, null);
            store.setKeyEntry(alias, privateKey, null, certs);
            outputStream = new ByteArrayOutputStream();
            store.store(outputStream, password.toCharArray());
            return outputStream.toByteArray();
        } finally
        {
            if (outputStream != null) outputStream.close();
        }
    }

    /**
     * 从P12数据中获取私钥
     *
     * @param p12      P12数据
     * @param alias    别名
     * @param password 密码
     * @return 私钥数据
     * @throws Exception 异常
     */
    public static PrivateKey getPrivateKey(byte[] p12, String alias, String password) throws Exception
    {
        ByteArrayInputStream inputStream = null;
        try
        {
            inputStream = new ByteArrayInputStream(p12);
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(inputStream, password.toCharArray());
            String keyAlias = null;
            if (alias == null)
            {
                Enumeration myEnum = keyStore.aliases();
                //使用While循环取最后一个别名
                while (myEnum.hasMoreElements())
                {
                    keyAlias = (String) myEnum.nextElement();
                }
            } else keyAlias = alias;

            return (PrivateKey) keyStore.getKey(keyAlias, password.toCharArray());
        } finally
        {
            if (inputStream != null) inputStream.close();
        }
    }

    /**
     * 从P12数据中获取证书
     *
     * @param p12      P12数据
     * @param alias    别名
     * @param password 密码
     * @return 证书数据
     * @throws Exception 异常
     */

    public static X509Certificate getX509Certificate(byte[] p12, String alias, String password) throws Exception
    {
        ByteArrayInputStream inputStream = null;
        try
        {
            inputStream = new ByteArrayInputStream(p12);
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(inputStream, password.toCharArray());
            String keyAlias = null;
            if (alias == null)
            {
                Enumeration myEnum = keyStore.aliases();
                //使用While循环取最后一个别名
                while (myEnum.hasMoreElements())
                {
                    keyAlias = (String) myEnum.nextElement();
                }
            } else keyAlias = alias;

            return (X509Certificate) keyStore.getCertificate(keyAlias);
        } finally
        {
            if (inputStream != null) inputStream.close();
        }
    }
}
