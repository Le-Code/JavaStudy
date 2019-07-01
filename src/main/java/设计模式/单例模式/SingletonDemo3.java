package 设计模式.单例模式;

/**
 * 懒汉模式
 * 线程安全操作
 */
public class SingletonDemo3 {

    private SingletonDemo3(){}

    private static SingletonDemo3 instance;

    private static final Object obj = new Object();

    public static SingletonDemo3 getInstance(){
        synchronized (obj){
            if (instance==null)
                instance = new SingletonDemo3();
            return instance;
        }
    }

}
