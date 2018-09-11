package xframe.kit;

import javax.net.ssl.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Http功能类，支持SSL，使用HttpsURLConnection
 *
 * @author ZhangQiang
 * @version 2016-3-1 19:06:52
 */
public class HttpKit
{

    private static final String GET = "GET";
    private static final String POST = "POST";
    public static int CONNECT_TIMEOUT = 10000;
    public static int READ_TIMEOUT = 20000;
    private static String DEFAULT_CHARSET = "UTF-8";

    /**
     * 忽视证书HostName
     */
    private static HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier()
    {
        public boolean verify(String s, SSLSession sslsession)
        {
            return true;
        }
    };

    /**
     * Ignore Certification
     */
    private static TrustManager ignoreCertificationTrustManger = new X509TrustManager()
    {
        private X509Certificate[] certificates;

        @Override
        public void checkClientTrusted(X509Certificate certificates[], String authType) throws CertificateException
        {
            if (this.certificates == null)
            {
                this.certificates = certificates;
            }
        }

        @Override
        public void checkServerTrusted(X509Certificate[] ax509certificate, String s) throws CertificateException
        {
            if (this.certificates == null)
            {
                this.certificates = ax509certificate;
            }
        }

        @Override
        public X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }
    };
    private static final SSLSocketFactory sslSocketFactory = initSSLSocketFactory();

    private static SSLSocketFactory initSSLSocketFactory()
    {
        try
        {
            TrustManager[] tm = {ignoreCertificationTrustManger};
            SSLContext sslContext = SSLContext.getInstance("TLS");    // ("TLS", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            return sslContext.getSocketFactory();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取连接
     *
     * @param url     String
     * @param method  请求方式get/post
     * @param headers 头信息
     * @return HttpURLConnection
     * @throws Exception
     */
    private static HttpURLConnection getHttpConnection(String url, String method, Map<String, String> headers) throws Exception
    {
        URL _url = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) _url.openConnection();
        if (conn instanceof HttpsURLConnection)
        {
            ((HttpsURLConnection) conn).setSSLSocketFactory(sslSocketFactory);
            ((HttpsURLConnection) conn).setHostnameVerifier(ignoreHostnameVerifier);
        }

        conn.setRequestMethod(method);
        conn.setDoOutput(true);
        conn.setDoInput(true);

        conn.setConnectTimeout(CONNECT_TIMEOUT);
        conn.setReadTimeout(READ_TIMEOUT);

        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.146 Safari/537.36");

        if (headers != null && !headers.isEmpty())
            for (Entry<String, String> entry : headers.entrySet())
                conn.setRequestProperty(entry.getKey(), entry.getValue());

        return conn;
    }

    /**
     * GET请求
     *
     * @param url        String
     * @param queryParas 参数数据Map<String, String>
     * @param headers    头数据Map<String, String>
     * @param charset    请求编码
     * @return String
     * @throws Exception
     */
    public static String get(String url, Map<String, String> queryParas, Map<String, String> headers, String charset) throws Exception
    {
        HttpURLConnection conn = null;
        try
        {
            conn = getHttpConnection(buildUrlWithQueryString(url, queryParas, charset), GET, headers);
            conn.connect();
            return new String(readResponse(conn), charset);
        } finally
        {
            if (conn != null)
            {
                conn.disconnect();
            }
        }
    }

    /**
     * GET请求
     *
     * @param url        String
     * @param queryParas Map<String, String>
     * @param charset    请求参数
     * @return String
     * @throws Exception
     */
    public static String get(String url, Map<String, String> queryParas, String charset) throws Exception
    {
        return get(url, queryParas, null, charset);
    }

    /**
     * GET请求
     *
     * @param url        String
     * @param queryParas 请求参数
     * @return String
     * @throws Exception
     */
    public static String get(String url, Map<String, String> queryParas) throws Exception
    {
        return get(url, queryParas, null, DEFAULT_CHARSET);
    }

    /**
     * GET请求
     *
     * @param url String
     * @return String
     * @throws Exception
     */
    public static String get(String url) throws Exception
    {
        return get(url, null, DEFAULT_CHARSET);
    }

    /**
     * 拉取文件内容，BASE64编码返回
     *
     * @param url 文件路径
     * @return String
     * @throws Exception
     */
    public static String getFile(String url) throws Exception
    {
        HttpURLConnection conn = null;
        try
        {
            conn = getHttpConnection(buildUrlWithQueryString(url, null, DEFAULT_CHARSET), GET, null);
            conn.connect();
            return Base64.getEncoder().encodeToString(readResponse(conn));
        } finally
        {
            if (conn != null)
            {
                conn.disconnect();
            }
        }
    }

    /**
     * POST方式提交参数
     *
     * @param url        String
     * @param queryParas Map<String, String>
     * @param data       POST文本
     * @param headers    头信息
     * @param charset    参数编码
     * @return String
     * @throws Exception
     */
    public static String post(String url, Map<String, String> queryParas, String data, Map<String, String> headers, String charset) throws Exception
    {
        HttpURLConnection conn = null;
        try
        {
            conn = getHttpConnection(buildUrlWithQueryString(url, queryParas, charset), POST, headers);
            conn.connect();

            if (data != null)
            {
                OutputStream out = conn.getOutputStream();
                out.write(data.getBytes(charset));
                out.flush();
                out.close();
            }

            return new String(readResponse(conn), charset);
        } finally
        {
            if (conn != null)
            {
                conn.disconnect();
            }
        }
    }

    /**
     * POST方式提交参数
     *
     * @param url        String
     * @param queryParas Map<String, String>
     * @return String
     * @throws Exception
     */
    public static String postMap(String url, Map<String, String> queryParas) throws Exception
    {
        return postMap(url, queryParas, DEFAULT_CHARSET);
    }

    /**
     * POST方式提交参数
     *
     * @param url        String
     * @param queryParas Map<String, String>
     * @param charset    参数编码
     * @return String
     * @throws Exception
     */
    public static String postMap(String url, Map<String, String> queryParas, String charset) throws Exception
    {
        return post(url, queryParas, null, null, charset);
    }

    /**
     * 直接POST内容，无参数
     *
     * @param url     String
     * @param data    String
     * @param charset 编码
     * @return String
     * @throws Exception
     */
    public static String postString(String url, String data, String charset) throws Exception
    {
        return post(url, null, data, null, charset);
    }

    /**
     * 直接POST内容，无参数
     *
     * @param url  String
     * @param data String
     * @return String
     * @throws Exception
     */
    public static String postString(String url, String data) throws Exception
    {
        return postString(url, data, DEFAULT_CHARSET);
    }

    /**
     * 读取返回的内容到字节数组中
     *
     * @param conn HttpURLConnection
     * @return byte[]
     * @throws Exception
     */
    private static byte[] readResponse(HttpURLConnection conn) throws Exception
    {
        try (InputStream inputStream = conn.getInputStream())
        {
            return ConvertKit.inputStream2byte(inputStream);
        }
    }

    /**
     * 拼装查询url和参数为完整请求地址
     *
     * @param url        String
     * @param queryParas Map<String, String>
     * @param charset    URL参数编码
     * @return String
     * @throws Exception
     */
    private static String buildUrlWithQueryString(String url, Map<String, String> queryParas, String charset) throws Exception
    {
        if (queryParas == null || queryParas.isEmpty()) return url;

        if (url.contains("?"))
        {
            return url + "&" + MapKit.encodeToUrl(queryParas, charset);
        } else
        {
            return url + "?" + MapKit.encodeToUrl(queryParas, charset);
        }

    }

    public static void main(String[] args) throws Exception
    {
//        System.out.println(HttpKit.get("http://www.bjgjj.gov.cn/", null, "gbk"));
//        System.out.println(HttpKit.get("https://www.alipay.com"));
//        System.out.println(HttpKit.getFile("http://www.jiananfinance.com/images/newindex/logoNew.png"));
    }
}
