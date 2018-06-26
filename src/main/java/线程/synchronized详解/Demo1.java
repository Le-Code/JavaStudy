package 线程.synchronized详解;

public class Demo1 implements Runnable {

    private static int i = 0;

    private synchronized void increase(){
        i++;
    }

    public void run() {
        for (int j = 0;j<200000;j++)
            increase();
    }

    public static void main(String[] args) throws InterruptedException {
        Demo1 instance=new Demo1();
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
