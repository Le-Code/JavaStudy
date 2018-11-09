package 并发.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutor01 implements Runnable{
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new ThreadPoolExecutor01());
        executorService.execute(new ThreadPoolExecutor01());
    }

    @Override
    public void run() {
        System.out.println("haha");
    }
}
