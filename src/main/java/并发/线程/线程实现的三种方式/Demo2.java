package 并发.线程.线程实现的三种方式;

/**
 * 实现runnable接口，资源共享
 */
public class Demo2 {

    static class CustomThread implements Runnable{

        int count = 100;

        @Override
        public void run() {
            while (count>0){
                System.out.println(Thread.currentThread().getName()+":"+count--);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {

        Runnable r = new CustomThread();
        Thread thread = new Thread(r);
        Thread thread1 = new Thread(r);
        thread.start();
        thread1.start();

    }

}
