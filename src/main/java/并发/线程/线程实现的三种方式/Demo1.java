package 并发.线程.线程实现的三种方式;

/**
 * 继承Thread类
 */
public class Demo1 {

    static class CustomThread extends Thread{

        int s = 100;

        @Override
        public void run() {
            while (s>0) {
                System.out.println(Thread.currentThread().getName() + ":" + s--);
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new CustomThread();
        thread.start();
        Thread thread1 = new CustomThread();
        thread1.start();
    }

}
