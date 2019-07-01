package 并发.线程.synchronized详解;

/**
 * 睡眠并不会释放资源
 */
public class SleepNotReleaseResource {

    private int i = 10;
    private Object object = new Object();

    public static void main(String[] args){
        SleepNotReleaseResource test1 = new SleepNotReleaseResource();
        MyThread thread1 =test1.new MyThread();
        MyThread thread2 = test1.new MyThread();
        thread1.start();
        thread2.start();
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            synchronized (object){
                i++;
                System.out.println("i:"+i);
                try {
                    System.out.println("并发.线程："+Thread.currentThread().getName()+"进入睡眠");
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("并发.线程："+Thread.currentThread().getName()+"线程结束");
                i++;
                System.out.println("i:"+i);
            }
        }
    }
}
