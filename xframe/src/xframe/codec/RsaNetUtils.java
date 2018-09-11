package xframe.codec;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

/**
 * Rsa对.Net语言的支持类
 *
 * @author ZhangQiang
 * @version 2010-8-2 9:56:37
 */
public class RsaNetUtils
{

    /**
     * 保存私钥为.net格式
     */
    public static String changePrivateKeyToDotNet(PrivateKey privateKey) throws Exception
    {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("RSAKeyValue");
        Element modulusElement = root.addElement("Modulus");
        modulusElement.setText(Base64.getEncoder().encodeToString(((RSAPrivateKey) privateKey).getModulus().toByteArray()));
        Element exponentElement = root.addElement("Exponent");
        exponentElement.setText(Base64.getEncoder().encodeToString(((RSAPrivateKey) privateKey).getPrivateExponent().toByteArray()));
        return document.asXML();
    }

    /**
     * 保存公钥为.net格式
     */
    public static String changePublicKeyToDotNet(PublicKey publicKey) throws Exception
    {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("RSAKeyValue");
        Element modulusElement = root.addElement("Modulus");
        modulusElement.setText(Base64.getEncoder().encodeToString(((RSAPublicKey) publicKey).getModulus().toByteArray()));
        Element exponentElement = root.addElement("Exponent");
        exponentElement.setText(Base64.getEncoder().encodeToString(((RSAPublicKey) publicKey).getPublicExponent().toByteArray()));
        return document.asXML();
    }
}
