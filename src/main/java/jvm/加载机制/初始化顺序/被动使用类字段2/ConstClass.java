package jvm.加载机制.初始化顺序.被动使用类字段2;

public class ConstClass {
    static {
        System.out.println("ConstClass init");
    }

    public static final String HELLOWORLD = "hello world";
}
