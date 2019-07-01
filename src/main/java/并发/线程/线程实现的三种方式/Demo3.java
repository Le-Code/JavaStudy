package 并发.线程.线程实现的三种方式;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口，带有返回值的线程创建
 */
public class Demo3 {

    static class CustomCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i<100;i++){
                sb.append(i+"");
                Thread.sleep(100);
            }
            return sb.toString();
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new CustomCallable());
        Thread thread = new Thread(task);
        thread.start();
        //调用这个方法会阻塞主线程
        String s = task.get();
        System.out.println(s);
    }

}
