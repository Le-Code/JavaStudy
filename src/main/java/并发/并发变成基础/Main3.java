package 并发.并发变成基础;

/**
 * java指令重排序
 * java内存模型允许编译器和处理器对指令重排序以提高运行性能
 * 1）int a = 1;
 * 2) int b = 2;
 * 3) int c = a + b
 * 变量c的值依赖a,b 所以重排序后能够保证3）操作能够在1）和2）之后，但是1）2）谁先执行就不一定，在单线程情况下是不会出现问题，但是在多线程下就会影响结果
 */
public class Main3 {

    public static boolean isReady = false;

    public static int num = 0;

    public static void main(String[] args) throws InterruptedException {

        ReadThread rt = new ReadThread();
        rt.start();
        WriteThread wh = new WriteThread();
        wh.start();

        Thread.sleep(10);
        rt.interrupt();
        System.out.println("main exit");

    }


    static class ReadThread extends Thread{
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                if (isReady){
                    System.out.println(num+num);
                }
                System.out.println("read thread...");
            }
        }
    }

    static class WriteThread extends Thread{
        @Override
        public void run() {
            num = 2;
            isReady = true;
            System.out.println("WriteThread set over ... ");
        }
    }

}
