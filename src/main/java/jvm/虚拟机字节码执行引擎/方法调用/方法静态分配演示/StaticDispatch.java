package jvm.虚拟机字节码执行引擎.方法调用.方法静态分配演示;

public class StaticDispatch {

    public static class Human{

    }

    public static class Man extends Human{

    }

    public static class Woman extends Human{

    }

    public void sayHello(Human human){
        System.out.println("hello guys");
    }

    public void sayHello(Man man){
        System.out.println("hello gentleman");
    }

    public void sayHello(Woman woman){
        System.out.println("hello woman");
    }

    public static void main(String[] args){
        Man man = new Man();
        Woman woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
    }
}
