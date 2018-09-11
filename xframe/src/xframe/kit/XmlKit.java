package xframe.kit;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * xpath解析xml
 * <pre>
 *     文档地址：
 *     http://www.w3school.com.cn/xpath/index.asp
 * </pre>
 *
 * @author zhangqiang
 * @version 2016-06-31 10:13:28
 */
public class XmlKit
{
    private final XPath path;
    private final Document doc;

    private XmlKit(InputSource inputSource) throws ParserConfigurationException, SAXException, IOException
    {
        DocumentBuilderFactory dbf = getDocumentBuilderFactory();
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(inputSource);
        path = getXPathFactory().newXPath();
    }

    private static XmlKit create(InputSource inputSource)
    {
        try
        {
            return new XmlKit(inputSource);
        } catch (ParserConfigurationException e)
        {
            throw new RuntimeException(e);
        } catch (SAXException e)
        {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static XmlKit of(InputStream is)
    {
        InputSource inputSource = new InputSource(is);
        return create(inputSource);
    }

    public static XmlKit of(File file)
    {
        InputSource inputSource = new InputSource(file.toURI().toASCIIString());
        return create(inputSource);
    }

    public static XmlKit of(String xmlContent) throws UnsupportedEncodingException
    {
        InputStream inputStream = new ByteArrayInputStream(xmlContent.getBytes());
        return of(inputStream);
    }

    private Object evalXPath(String expression, Object item, QName returnType)
    {
        item = null == item ? doc : item;
        try
        {
            return path.evaluate(expression, item, returnType);
        } catch (XPathExpressionException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取String
     *
     * @param expression 路径
     * @return String
     */
    public String getString(String expression)
    {
        return (String) evalXPath(expression, null, XPathConstants.STRING);
    }

    /**
     * 获取Boolean
     *
     * @param expression 路径
     * @return String
     */
    public Boolean getBoolean(String expression)
    {
        return (Boolean) evalXPath(expression, null, XPathConstants.BOOLEAN);
    }

    /**
     * 获取Number
     *
     * @param expression 路径
     * @return {Number}
     */
    public Number getNumber(String expression)
    {
        return (Number) evalXPath(expression, null, XPathConstants.NUMBER);
    }

    /**
     * 获取某个节点
     *
     * @param expression 路径
     * @return {Node}
     */
    public Node getNode(String expression)
    {
        return (Node) evalXPath(expression, null, XPathConstants.NODE);
    }

    /**
     * 获取子节点
     *
     * @param expression 路径
     * @return NodeList
     */
    public NodeList getNodeList(String expression)
    {
        return (NodeList) evalXPath(expression, null, XPathConstants.NODESET);
    }


    /**
     * 获取String
     *
     * @param node       节点
     * @param expression 相对于node的路径
     * @return String
     */
    public String getString(Object node, String expression)
    {
        return (String) evalXPath(expression, node, XPathConstants.STRING);
    }

    /**
     * 获取
     *
     * @param node       节点
     * @param expression 相对于node的路径
     * @return String
     */
    public Boolean getBoolean(Object node, String expression)
    {
        return (Boolean) evalXPath(expression, node, XPathConstants.BOOLEAN);
    }

    /**
     * 获取
     *
     * @param node       节点
     * @param expression 相对于node的路径
     * @return {Number}
     */
    public Number getNumber(Object node, String expression)
    {
        return (Number) evalXPath(expression, node, XPathConstants.NUMBER);
    }

    /**
     * 获取某个节点
     *
     * @param node       节点
     * @param expression 路径
     * @return {Node}
     */
    public Node getNode(Object node, String expression)
    {
        return (Node) evalXPath(expression, node, XPathConstants.NODE);
    }

    /**
     * 获取子节点
     *
     * @param node       节点
     * @param expression 相对于node的路径
     * @return NodeList
     */
    public NodeList getNodeList(Object node, String expression)
    {
        return (NodeList) evalXPath(expression, node, XPathConstants.NODESET);
    }

    /**
     * 针对没有嵌套节点的简单处理
     *
     * @return map集合
     */
    public Map<String, String> toMap()
    {
        Element root = doc.getDocumentElement();
        Map<String, String> params = new HashMap<String, String>();

        // 将节点封装成map形式
        NodeList list = root.getChildNodes();
        for (int i = 0; i < list.getLength(); i++)
        {
            Node node = list.item(i);
            params.put(node.getNodeName(), node.getTextContent());
        }
        // 含有空白符会生成一个#text参数
        params.remove("#text");
        return params;
    }

    private static DocumentBuilderFactory getDocumentBuilderFactory()
    {
        return XmlKit.XmlHelperHolder.documentBuilderFactory;
    }

    private static XPathFactory getXPathFactory()
    {
        return XmlKit.XmlHelperHolder.xPathFactory;
    }

    /**
     * 内部类单例
     */
    private static class XmlHelperHolder
    {
        private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        private static XPathFactory xPathFactory = XPathFactory.newInstance();
    }

    public static void main(String[] args) throws UnsupportedEncodingException
    {
//        String xml = "<xml>\n" +
//                "<ToUserName><![CDATA[张强]]></ToUserName>\n" +
//                "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
//                "<CreateTime>1433332012</CreateTime>\n" +
//                "   <MsgType><![CDATA[event]]></MsgType>\n" +
//                "   <Event><![CDATA[ShakearoundUserShake]]></Event>\n" +
//                "   <ChosenBeacon>\n" +
//                "       <Uuid><![CDATA[uuid]]></Uuid>\n" +
//                "       <Major>major</Major>\n" +
//                "       <Minor>minor</Minor>\n" +
//                "       <Distance>0.057</Distance>\n" +
//                "   </ChosenBeacon>\n" +
//                "   <AroundBeacons>\n" +
//                "       <AroundBeacon>\n" +
//                "           <Uuid><![CDATA[uuid]]></Uuid>\n" +
//                "           <Major>major</Major>\n" +
//                "           <Minor>minor</Minor>\n" +
//                "           <Distance>166.816</Distance>\n" +
//                "       </AroundBeacon>\n" +
//                "       <AroundBeacon>\n" +
//                "           <Uuid><![CDATA[uuid]]></Uuid>\n" +
//                "           <Major>major</Major>\n" +
//                "           <Minor>minor</Minor>\n" +
//                "           <Distance>15.013</Distance>\n" +
//                "       </AroundBeacon>\n" +
//                "   </AroundBeacons>\n" +
//                "</xml>";
//
//        XmlKit xmlKit = XmlKit.of(xml);
//        System.out.println(xmlKit.getString("//ToUserName"));
//        System.out.println(xmlKit.getString("//ChosenBeacon/Distance"));

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response><error>330</error><message></message></response>";

        XmlKit xmlKit = XmlKit.of(xml);
        System.out.println(xmlKit.getString("/response/error"));
    }

}
