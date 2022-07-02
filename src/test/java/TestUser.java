import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import pub.zgq.CloudAlbum.service.UserService;

//复合注解替代上方两个注解
@SpringJUnitConfig(locations = "classpath:springMVC.xml")
public class TestUser {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        //userService.findUser();
        //System.out.println("test...");
    }
}
