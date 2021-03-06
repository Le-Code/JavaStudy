package 并发.锁原理.ReentrantLock原理;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock来实现一个简单的线程安全的list
 */
public class ReentrantLockList {
    //线程不安全的list
    private ArrayList<String> array = new ArrayList<>();
    //独占锁
    private ReentrantLock lock = new ReentrantLock();

    //添加元素
    public void add(String e){
        lock.lock();
        try {
            array.add(e);
        }finally {
            lock.unlock();
        }
    }

    //删除元素
    public void remove(String e){
        lock.lock();
        try {
            array.remove(e);
        }finally {
            lock.unlock();
        }
    }

    //获取数据
    public String get(int index){
        lock.lock();
        try {
            return array.get(index);
        }finally {
            lock.unlock();
        }
    }
}
