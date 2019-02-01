package 并发.锁原理.抽象同步队列;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

/**
 * 使用前面创建的锁实现生产者消费者模型
 */
public class TestNonReentrantLock2 {
    final static NonReentrantLock lock = new NonReentrantLock();
    final static Condition notFull = lock.newCondition();
    final static Condition notEmpty = lock.newCondition();

    final static Queue<String> queue = new LinkedBlockingQueue<>();
    final static int queueSize = 5;

    public static void main(String[] args){
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    //如果队列元素满了，则等待
                    while (queue.size()==queueSize)
                        notEmpty.await();
                    //添加元素到队尾
                    System.out.println("add ele");
                    queue.add("ele");
                    //唤醒消费者线程
                    notFull.signalAll();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (queue.size()==0)
                        notFull.await();
                    //消费一个元素
                    String ele = queue.poll();
                    System.out.println(ele);
                    notEmpty.signalAll();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        queue.add("ele");
        queue.add("ele");
        queue.add("ele");
        queue.add("ele");
        queue.add("ele");
        //启动线程
        producer.start();
        consumer.start();
    }
}
