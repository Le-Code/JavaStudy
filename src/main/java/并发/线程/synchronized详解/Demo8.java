package 并发.线程.synchronized详解;

import java.util.concurrent.TimeUnit;

/**
 * 非阻塞状态的线程需要手动进行检测并结束程序
 */
public class Demo8 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true){
                    if (this.isInterrupted()){
                        System.out.println("线程中断");
                        break;
                    }
                }
                System.out.println("已跳出循环");
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        t1.interrupt();
    }
}
