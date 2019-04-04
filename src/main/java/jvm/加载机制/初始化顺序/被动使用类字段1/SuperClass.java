package jvm.加载机制.初始化顺序.被动使用类字段1;

public class SuperClass {

    static {
        System.out.println("superClass init");
    }

    public static int value = 123;

}
