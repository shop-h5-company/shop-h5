package xframe.ca;

import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

/**
 * X509证书操作功能类
 *
 * @author ZhangQiang
 * @version 2010-2-1 15:06:08
 */
public class X509Utils
{
    /**
     * 将字节数据转换为证书对象
     *
     * @param in - byte[] 证书信息
     * @return X509Certificate
     * @throws Exception 异常
     */
    public static X509Certificate parseToX509Cert(byte[] in) throws Exception
    {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        return (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(in));
    }

    /**
     * 验证证书是否属于指定的CA证书链
     *
     * @param cert   待验证证书
     * @param rootCa CA证书链
     * @return boolean
     */
    public static boolean isCertIssuedByLegalCA(X509Certificate cert, X509Certificate rootCa)
    {
        return isCertIssuedByLegalCA(cert, rootCa.getPublicKey());
    }

    /**
     * 验证证书是否属于指定的CA证书链
     *
     * @param cert      待验证证书
     * @param publicKey CA证书链公钥
     * @return boolean
     */
    public static boolean isCertIssuedByLegalCA(X509Certificate cert, PublicKey publicKey)
    {
        if ((cert == null) || (publicKey == null)) return false;

        try
        {
            cert.verify(publicKey);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * 验证证书有效期
     *
     * @param cert 证书
     * @param date 有效时间，null为当前时间 new Date()
     * @return boolean
     */
    public static boolean isCertValid(X509Certificate cert, Date date)
    {
        if (cert == null) return false;
        if (date == null) date = new Date();
        try
        {
            cert.checkValidity(date);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }
}
