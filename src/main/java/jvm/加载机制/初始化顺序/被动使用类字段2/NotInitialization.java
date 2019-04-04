package jvm.加载机制.初始化顺序.被动使用类字段2;

public class NotInitialization {

    public static void main(String[] args){
        System.out.println(ConstClass.HELLOWORLD);
    }

}
