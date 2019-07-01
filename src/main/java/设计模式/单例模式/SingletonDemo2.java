package 设计模式.单例模式;

/**
 * 饿汉模式
 * 在装载类的时候就已经初始化，称之为饿汉模式
 * 线程安全的
 */
public class SingletonDemo2 {

    private SingletonDemo2(){}

    private static SingletonDemo2 instance = new SingletonDemo2();

    public static SingletonDemo2 getInstance(){
        return instance;
    }

}
