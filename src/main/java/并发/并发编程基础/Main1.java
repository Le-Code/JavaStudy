package 并发.并发编程基础;

/**
 * 了解interrupt和interrupted方法的不同之处
 */
public class Main1 {

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(){
            @Override
            public void run() {
                for (;;){
                }
            }
        };
        //启动线程
        threadOne.start();

        //设置中断标记
        threadOne.interrupt();

        //获取中断标记
        System.out.println("isInterrupted:"+threadOne.isInterrupted());

        //获取中断标记并重置
        System.out.println("isInterrupted:"+threadOne.interrupted());

        //获取中断标记并重置
        System.out.println("isInterrupted:"+Thread.interrupted());

        //获取中断标记
        System.out.println("isInterrupted:"+threadOne.isInterrupted());

        threadOne.join();

        System.out.println("main thread is over");

        /*\
        程序的输出结果是true，false，false，true。
        是因为interrupted()表示是的当前线程Main主线程的中断标记，尽管调用了threadOne。
        由于线程调用interrupt并不会立即中断，而是需要程序运行到响应中断的地方（wait,join,sleep)，所以threadOne永远不会中断，又因为主线程调用了子线程的join()方法后被阻塞，所以主线程也永远不会结束
         */
    }

}
