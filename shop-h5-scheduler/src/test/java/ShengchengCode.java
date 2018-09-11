import java.math.BigDecimal;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.mybatis.model.generator.Users;
import com.shop.scheduler.InviteCodeScheduler;
import com.shop.service.UserService;

/**
 * Created on 2016-07-05 11:19.
 *
 * @author FanShukui
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class ShengchengCode {
    @Resource
    InviteCodeScheduler inviteCodeScheduler;

    @Test
    public void inviteCode() throws Exception{
    	inviteCodeScheduler.inviteCode();
    }
    
}
