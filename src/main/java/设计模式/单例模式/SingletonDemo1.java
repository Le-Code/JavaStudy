package 设计模式.单例模式;

/**
 * 懒汉单例模式
 * 在第一次调用时才会创建实例
 * 线程不安全
 */
public class SingletonDemo1 {

    private SingletonDemo1(){}

    private static SingletonDemo1 instance;

    public static SingletonDemo1 getInstance(){
        if (instance==null)
            instance = new SingletonDemo1();
        return instance;
    }

}
