package 线程.synchronized详解;

public class Demo2 implements Runnable {
    static int i = 0;

    /**
     * 作用于实例方法，锁对象是实例对象
     */
    public synchronized void increase(){
        i++;
    }

    public void run() {
        for (int j = 0;j<20000;j++)
            increase();
    }

    public static void main(String[] args) throws InterruptedException {
        Demo2 instance1 = new Demo2();
        Demo2 instance2 = new Demo2();
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
