package 并发.并发编程基础;

/**
 * join方法相应中断
 */
public class JoinRespondInterrupt {

    public static void main(String[] args) {
        Thread threadOne = new Thread(){
            @Override
            public void run() {
                System.out.println("thread one start run");
                while (true){
                    if (Thread.currentThread().isInterrupted()){
                        break;
                    }
                }
            }
        };
        final Thread mainThread = Thread.currentThread();
        Thread threadTwo = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //中断主线程，但是注意，只会中断主线程，但是threadOne依旧还是在运行
                mainThread.interrupt();
            }
        };

        threadOne.start();

        threadTwo.start();

        try {
            //等待threadOne的执行结束
            threadOne.join();
        }catch (InterruptedException e){
            e.printStackTrace();
            //如果主线程被中断，那么也中断threadOne，如果不中断的话，即使主线程中断那么子线程还是在继续运行
            threadOne.interrupt();
        }

        System.out.println("main thread interrupted");
    }

}
