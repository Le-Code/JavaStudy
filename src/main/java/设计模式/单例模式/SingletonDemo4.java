package 设计模式.单例模式;

/**
 * 懒汉模式
 * 线程安全，解决Demo3中不必要的同步操作
 */
public class SingletonDemo4 {

    private SingletonDemo4(){}

    private static SingletonDemo4 instance;

    private static final Object obj = new Object();

    public static SingletonDemo4 getInstance(){
        if (instance==null){
            synchronized (obj){
                if (instance==null) //这里还需要再判断一次，防止有多个线程进入这一步，然后创建多个实例
                    instance=new SingletonDemo4();
            }
        }
        return instance;
    }

}
