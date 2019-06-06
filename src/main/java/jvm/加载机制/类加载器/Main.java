package jvm.加载机制.类加载器;

import org.omg.CORBA.StringHolder;

/**
 * ClassLoader.loadClass()和 Class.forName()的却别
 * 是否执行初始化代码
 */
public class Main {

    static class Hello{
        static {
            System.out.println("hello");
        }
    }

    public static void main(String[] args){
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String className = Main.class.getName()+"$Hello";
        try {
            Class<?> aClass = classLoader.loadClass(className);//不会输出hello

//            Class.forName(className);//会输出hello
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
