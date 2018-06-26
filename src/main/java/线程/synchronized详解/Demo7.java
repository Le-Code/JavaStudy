package 线程.synchronized详解;

import java.util.concurrent.TimeUnit;

/**
 * 线程的中断
 * public void Thread.interrupt();//中断线程（实例方法）
 * public boolean Thread.isInterrupted();//判断线程是否被中断（实例方法）
 * public static boolean Thread.interrupted();//判断是否被中断并清除当前中断状态（静态方法）
 */
public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    while (true){
                        TimeUnit.SECONDS.sleep(2);
                    }
                }catch (InterruptedException e){
                    System.out.println("interrupted when sleep");
                    boolean interrupt = this.isInterrupted();
                    System.out.println("中断位被恢复："+interrupt);
                }
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        //中断处于阻塞状态的线程
        t1.interrupt();
    }
}
