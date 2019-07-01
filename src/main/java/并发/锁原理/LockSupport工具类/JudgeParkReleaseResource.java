package 并发.锁原理.LockSupport工具类;

import java.util.concurrent.locks.LockSupport;

/**
 * 判断park犯法阻塞线程后是否会释放资源
 */
public class JudgeParkReleaseResource {

    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(){
            @Override
            public void run() {
                System.out.println("threadOne 尝试获取obj资源");
                synchronized (obj){
                    System.out.println("threadOne获取到obj资源");

                    System.out.println("threadOne开启park方法阻塞线程");
                    LockSupport.park();
                }
            }
        };

        Thread threadTwo = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadTwo尝试获取obj资源");
                synchronized (obj){
                    System.out.println("threadTwo获取到资源");
                }
            }
        };

        threadOne.start();
        threadTwo.start();

        Thread.sleep(10000);
        LockSupport.unpark(threadOne);
    }

}
