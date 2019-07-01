package 并发.线程.synchronized详解;

/**
 * 可重入行
 */
public class Demo6 implements Runnable {

    static int i = 0;

    static int j = 0;

    static Demo6 instance = new Demo6();

    public void run() {
        for (int j = 0;j<200000;j++){
            synchronized (this){
                i++;
                increase();//synchronized的重入性
            }
        }
    }

    public synchronized void increase(){
        j++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}
