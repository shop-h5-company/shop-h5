package xframe.trans;

import com.alibaba.fastjson.JSON;

import java.util.Map;

import xframe.kit.HttpKit;
import xframe.kit.MapKit;

/**
 * 通信协议客户端
 *
 * @author zhangqiang
 * @version 2014-07-31 10:13:28
 */
public class TransClient
{
    public static TransResponse sendRequest(String url) throws Exception
    {
        return sendRequest(url, null);
    }

    public static TransResponse sendRequest(String url, Map<String, String> params) throws Exception
    {
        if (params != null && !params.isEmpty())
        {
            String queryString = MapKit.encodeToUrl(params, "utf-8");
            url = url + "?" + queryString;
        }
        String result = HttpKit.get(url);
        return JSON.parseObject(result, TransResponse.class);
    }
}
