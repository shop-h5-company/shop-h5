import java.math.BigDecimal;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.mybatis.model.generator.Users;
import com.shop.service.UserService;

/**
 * Created on 2016-07-05 11:19.
 *
 * @author FanShukui
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class UserTest {
    @Resource
    UserService userService;

    @Test
    public void testAdd(){
        Users users = userService.queryById(1L);
        System.out.print(userService.encryptPassword("111111","1234567890"));
    }
    
    @Test
   public void testSS() {
	   BigDecimal balanceAmt=new BigDecimal("0.04");
   	double planProfit;
   	planProfit=0.05/365*0.04;
   	BigDecimal multiply = new BigDecimal("0.05").divide(new BigDecimal("365"),8, BigDecimal.ROUND_HALF_EVEN).multiply(balanceAmt);
   	System.out.println(planProfit);
   	System.out.println(balanceAmt.doubleValue());
   	System.out.println(multiply);
    }
}
