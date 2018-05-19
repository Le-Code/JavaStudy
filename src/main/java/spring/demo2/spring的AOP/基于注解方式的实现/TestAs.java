package spring.demo2.spring的AOP.基于注解方式的实现;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAs {

    @Test
    public void testAs(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/demo2.xml");
        OrderDao orderDao = (OrderDao) context.getBean("orderDao");
        orderDao.add();
    }
}
