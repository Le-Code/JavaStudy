package spring_study.加载bean的三种方式.静态工厂;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean1 bean1 = context.getBean(Bean1.class);
        System.out.println(bean1);
    }

}
