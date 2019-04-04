package jvm.加载机制.初始化顺序.被动使用类字段1;

public class SubClass extends SuperClass {
    static {
        System.out.println("subClass init");
    }
}
