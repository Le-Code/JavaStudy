package 线程.synchronized详解;

public class Demo4 implements Runnable {

    static Demo4 instance = new Demo4();

    static int i = 0;

    public void run() {
        //修饰代码块
        synchronized (instance){
            for (int j = 0;j<200000;j++)
                i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Demo4 instance1 = new Demo4();
        Demo4 instance2 = new Demo4();
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}
