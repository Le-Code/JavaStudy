package spring.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo1 {

    @Test
    public void testHelloWorld(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/demo1.xml");
        HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");
        HelloWord helloWord = service.getHelloWord();
        helloWord.sayHello();
    }

}
