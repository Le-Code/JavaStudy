package spring.demo2.spring的AOP.基于代理类的aop实现;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void testAop(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/demo2.xml");
        UserDao userDao = (UserDao) context.getBean("userDaoProxy");
        userDao.add();
        userDao.delete();
        userDao.addUser("jerry");
    }

}
