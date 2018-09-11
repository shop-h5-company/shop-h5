import redis.clients.jedis.Jedis;

/**
 * Created on 2016-06-08 19:31.
 *
 * @author FanShukui
 */
public class TestRedis {
    public static void main(String[] args) {
        try {
            String host = "127.0.0.1";//控制台显示访问地址
            int port = 16379;
            Jedis jedis = new Jedis(host, port);
            //鉴权信息由用户名:密码拼接而成
            jedis.auth("f96f37232afd4d6c:JianAnRedis2016PaSsW0rdredis");//instance_id:password
            String key = "redis";
            String value = "aliyun-redis";
            //select db默认为0
            jedis.select(0);
            //set一个key
            jedis.set(key, value);
            System.out.println("Set Key " + key + " Value: " + value);
            //get 设置进去的key
//            String getvalue = jedis.get(key);
//            System.out.println("Get Key " + key + " ReturnValue: " + getvalue);
            jedis.quit();
            jedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
