package spring_study.加载bean的三种方式.默认构造方式;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean bean = (Bean) context.getBean("bean");
        System.out.println(bean);
    }

}
