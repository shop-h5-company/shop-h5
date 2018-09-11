package xframe.kit;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.net.URLEncoder;
import java.util.*;

/**
 * Map操作功能类
 *
 * @author zhangqiang
 * @version 2014-09-31 10:13:28
 */
public class MapKit
{
    /**
     * 排序Map中的元素后把内容连接成字符串，所有值都参与排序
     *
     * @param map Map
     * @return String
     */
    public static String sortMap(Map map)
    {
        return sortMap(map, false);
    }

    /**
     * 排序Map中的元素后把内容连接成字符串，值为空不参与排序
     *
     * @param map     Map
     * @param nullNot boolean，true-null值不参与排序
     * @return String
     */
    public static String sortMap(Map map, boolean nullNot)
    {
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < keys.length; i++)
        {
            Object key = keys[i];
            Object object = map.get(key);
            if (object instanceof String[]) object = ((String[]) object)[0];

            if (nullNot && StringUtils.isBlank(Objects.toString(object, ""))) continue;

            if (i > 0) sb.append("&");
            sb.append(key).append("=").append(Objects.toString(object, ""));
        }
        return sb.toString();
    }

    /**
     * 把XML的元素转到Map中，仅支持一级节点
     *
     * @param xmlData String
     * @return Map
     * @throws Exception
     */
    public static Map convertXmlToMap(String xmlData) throws Exception
    {
        Map<String, String> map = new HashMap<>();

        Document doc = DocumentHelper.parseText(xmlData);
        Element root = doc.getRootElement();
        Iterator iter = root.elementIterator();
        while (iter.hasNext())
        {
            Element element = (Element) iter.next();
            String name = element.getName();
            String value = (String) element.getData();
            map.put(name, value);
        }
        return map;
    }

    /**
     * 把Map转为XML
     *
     * @param map      Map
     * @param rootText String
     * @return String
     */
    public static String convertMapToXml(Map map, String rootText)
    {
        return convertMapToXml(map, rootText, null, null, null);
    }

    /**
     * 把Map转为XML
     *
     * @param map      Map
     * @param rootText String
     * @return String
     */
    public static String convertMapToXml(Map map, String rootText, String charset)
    {
        return convertMapToXml(map, rootText, null, null, charset);
    }

    /**
     * 把Map转为XML
     *
     * @param map      Map
     * @param rootText String
     * @return String
     */
    public static String convertMapToXml(Map map, String rootText, String rootAttributeName, String rootAttributeValue, String charset)
    {
        Document document = DocumentHelper.createDocument();
        if (charset != null) document.setXMLEncoding(charset);
        Element root = document.addElement(rootText);
        if (rootAttributeName != null && rootAttributeValue != null)
            root.addAttribute(rootAttributeName, rootAttributeValue);

        for (Object key : map.keySet())
        {
            String value = Objects.toString(map.get(key));
            Element modulusElement = root.addElement(Objects.toString(key));
            modulusElement.addCDATA(value);
        }

        if (charset != null) return document.asXML();
        else return document.getRootElement().asXML();
    }

    /**
     * 把Map的值转为url，用&连接
     *
     * @param queryMap Map<String, String>
     * @param charset  String
     * @return String
     * @throws Exception
     */
    public static String encodeToUrl(Map<String, String> queryMap, String charset) throws Exception
    {
        StringBuilder sb = new StringBuilder();

        for (String key : queryMap.keySet())
        {
            String value = queryMap.get(key);

            String encodedValue = "";
            if (StringUtils.isNotEmpty(value)) encodedValue = URLEncoder.encode(value, charset);

            if (sb.length() > 0) sb.append("&");

            sb.append(key).append("=").append(encodedValue);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception
    {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "lala1");
        map.put("key2", new String[]{"lala2", ""});
        map.put("key3", null);
//        map.put("key4", "张大妈");

        String ss = MapKit.sortMap(map);
        System.out.println(ss);

////        String xml = MapKit.convertMapToXml(map, "Message","no","123", "GBK");
////        String xml = MapKit.convertMapToXml(map, "xml", "GBK");
//        String xml = MapKit.convertMapToXml(map, "xml");
////        String xml = MapKit.encodeToUrl(map, "UTF-8");
//        System.out.println(xml);
//        Map<String, String> m = MapKit.convertXmlToMap(xml);
//        m.clear();
    }
}