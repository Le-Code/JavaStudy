package 并发.锁原理.ReentrantLock原理;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReentrantReadWriteLock {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private static int num = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread threadWrite = new Thread(){
            @Override
            public void run() {
                lock.readLock().lock();
                try {
                    for (int i = 0;i<10;i++){
                        num++;
                        System.out.println("hreadWrite:"+num);
                        Thread.sleep(1000);
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.readLock().unlock();
                }
            }
        };

        Thread threadRead = new Thread(){
            @Override
            public void run() {
                lock.readLock().lock();
                try {
                    for (int i = 0;i<10;i++){
                        System.out.println(num);
                        Thread.sleep(1000);
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.readLock().unlock();
                }
            }
        };

        threadWrite.start();

        threadRead.start();




        System.out.println(num);

    }

}
