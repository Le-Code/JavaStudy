package 并发.锁原理.LockSupport工具类;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

public class Main {

    /**
     * 在main方法中调用park方法，当前线程会被挂起，因为默认情况下调用线程是不持有许可证的
     */
    @Test
    public void testMainPark(){
        System.out.println("one");
        LockSupport.park();
        System.out.println("two");
    }

    /**
     * 测试调用unPark方法后再调用park方法，线程则会被返回
     */
    @Test
    public void testMainUnPark(){
        System.out.println("one");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("two");
    }

    /**
     * 通过一个例子来深入理解park和unPark
     */
    @Test
    public void learnParkAndUnParkDeep() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park");
                LockSupport.park();//调用park，挂起自己
                System.out.println("child thread unPark");
            }
        });
        //启动子线程
        thread.start();
        //主线程睡眠1s
        Thread.sleep(1000);
        System.out.println("main thread unPark");
        //调用unPark方法让thread线程持有许可证，然后park方法返回
        LockSupport.unpark(thread);
    }

    /**
     * 线程通过park阻塞，通过终端返回
     */
    @Test
    public void parkWakeByInterrupted() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park");
                //调用park ，挂起自己，只有被中断才退出循环
                while (!Thread.currentThread().isInterrupted()){
                    LockSupport.park();
                }

                System.out.println("child thread unPark");
            }
        });
        //启动子线程
        thread.start();
        //主线程睡眠1s
        Thread.sleep(1000);
        System.out.println("main thread unPark");
        //中断子线程
        thread.interrupt();
    }
}
