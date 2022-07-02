import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.ibatis.io.Resources;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pub.zgq.CloudAlbum.dao.UserDao;
import pub.zgq.CloudAlbum.pojo.Image;
import pub.zgq.CloudAlbum.pojo.User;

import java.io.InputStream;

public class TestMbatis {

    @Test
    public void run1()throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        UserDao userDao = ac.getBean(UserDao.class);
        User user = new User();
        user.setUsername("zhanggaoqiang");
        user.setPassword("zgq123456");
        userDao.findUser(user);

    }
    @Test
    public void testselect() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        UserDao userDao = ac.getBean(UserDao.class);
        Image imageOne = userDao.findImageOne(1);
        System.out.println(imageOne);
    }
}
