package 并发.锁原理.ReentrantLock原理;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread threadOne = new Thread(){
            @Override
            public void run() {
                lock.lock();
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        };

        Thread threadTwo = new Thread(){
            @Override
            public void run() {
                lock.lock();
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        };

        threadOne.start();
        threadTwo.start();

    }

}
