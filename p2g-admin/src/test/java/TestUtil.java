import com.alibaba.fastjson.JSON;
import com.p2g.mybatis.model.generator.Admin;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created on 2016-06-29 19:12.
 *
 * @author FanShukui
 */
public class TestUtil {
    public static void main(String[] args) {
        Admin a = new Admin();
        a.setPassword("1111111");
        a.setAdminCode("23r2e323");

        AdminTmp b = new AdminTmp();
        b.setAdminName("hello");

        try {
            BeanUtils.copyProperties(a,b);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.print(JSON.toJSONString(a));
    }

}
