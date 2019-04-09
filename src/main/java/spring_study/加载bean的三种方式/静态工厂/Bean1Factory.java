package spring_study.加载bean的三种方式.静态工厂;

public class Bean1Factory {

    public static Bean1 getBean1(){
        return new Bean1();
    }
}
