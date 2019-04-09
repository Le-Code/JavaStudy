package spring_study.加载bean的三种方式.实例化工厂;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean2 bean2 = context.getBean(Bean2.class);
        System.out.println(bean2);
    }
}
