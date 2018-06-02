package 实验;

import org.junit.Test;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    private static Queue<Integer>mQueue = new LinkedBlockingQueue<Integer>();

    public static void main(String[] a){
        Scanner scanner = new Scanner(System.in);
        while (true){
            mQueue.add(scanner.nextInt());
            new MThread().start();
        }
    }

    static class MThread extends Thread{
        @Override
        public void run() {
            while (!mQueue.isEmpty()){
                System.out.println(mQueue.poll());
            }
        }
    }
}
