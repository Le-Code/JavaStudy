package spring.demo2.spring的AOP.AspectJ开发;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestAspectJ {

    @Test
    public void aspectJTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/demo2.xml");
        UserDao userDao = (UserDao) context.getBean("uDao");
//        userDao.add();
        userDao.getSum(1,2);
    }
}
