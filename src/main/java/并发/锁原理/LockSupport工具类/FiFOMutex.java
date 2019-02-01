package 并发.锁原理.LockSupport工具类;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * 手动实现一个先进先出的锁
 */
public class FiFOMutex {

    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters = new ConcurrentLinkedDeque<>();

    public void lock(){
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        waiters.add(current);

        //如果当前线程不是队首或者当前锁已经被其他线程获取，使用park阻塞自己
        while (waiters.peek()!=current||!locked.compareAndSet(false,true)){
            LockSupport.park(this);
            //如果被中断，忽略，设置标记位，继续循环判断
            if (Thread.interrupted()){
                wasInterrupted = true;
            }
        }
        waiters.remove();
        if (wasInterrupted)
            current.interrupt();
    }

    public void unLock(){
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }

}
