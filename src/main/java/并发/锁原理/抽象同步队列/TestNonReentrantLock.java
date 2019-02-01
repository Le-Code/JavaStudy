package 并发.锁原理.抽象同步队列;

public class TestNonReentrantLock {

    private static NonReentrantLock lock = new NonReentrantLock();

    public static void main(String[] args){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("start sleep");
                try {
                    Thread.sleep(1000);
                    System.out.println("sleep time out");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();
    }

}
