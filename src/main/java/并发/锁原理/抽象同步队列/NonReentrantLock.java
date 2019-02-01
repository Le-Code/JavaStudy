package 并发.锁原理.抽象同步队列;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 给予AQS实现一个不可重入得独占锁
 * 定义state含义：0表示目前灭有被线程持有，1表示已经被一个线程持有
 */
public class NonReentrantLock implements Lock, Serializable {

    /**
     * 内部帮助类
     */
    private static class Sync extends AbstractQueuedSynchronizer{
        //判断锁是否已经被持有
        public boolean isHeldExclusively(){
            return getState() == 1;
        }

        /**
         * 如果state为0 ，尝试获取锁
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            assert arg == 1;//正确则继续执行，错误则抛出AssertionError终止执行
            if (compareAndSetState(0,1)){
                //设置持有者为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 尝试释放锁
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            assert arg == 1;
            if (getState()==0)
                throw new IllegalMonitorStateException();
            //设置持有者为null
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition(){
            return new ConditionObject();
        }
    }

    /**
     * 创建一个Sync来做具体的工作
     */
    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }
}
