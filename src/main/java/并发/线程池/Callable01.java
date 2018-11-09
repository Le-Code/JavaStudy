package 并发.线程池;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程提供返回值
 */
public class Callable01 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "我叫姚健";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new Callable01());
        new Thread(task).start();
        System.out.println(task.get());
    }
}
