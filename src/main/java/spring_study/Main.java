package spring_study;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 实现是一个小例子
 */
public class Main {

    public static class TestBean{
        private String str = "this";

        public void setStr(String str){
            this.str = str;
        }
        public String getStr(){
            return this.str;
        }
    }

    public static void main(String[] args){
        BeanFactory cf = new XmlBeanFactory(new ClassPathResource("spring_study/main.xml"));
        TestBean bean = (TestBean) cf.getBean("testBean");
        bean.setStr("test");
        System.out.println(bean.getStr());
    }

}
