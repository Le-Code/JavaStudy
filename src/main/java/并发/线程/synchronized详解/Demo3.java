package 并发.线程.synchronized详解;

public class Demo3 implements Runnable {
    static int i = 0;

    /**
     * 作用于静态方法，锁对象是类对象
     */
    public static synchronized void increase(){
        i++;
    }

    /**
     * 作用于实例方法
     */
    public synchronized void increase2(){
        i++;
    }

    public void run() {
        for (int j = 0;j<20000;j++)
            increase();
    }

    public static void main(String[] args) throws InterruptedException {
        Demo3 instance1 = new Demo3();
        Demo3 instance2 = new Demo3();
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
