package 并发.锁原理.读写锁.demo;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 实现一个线程安全的list，使用ReentrantReadWriteLock来进行改造
 */
public class ReentrantLockList {
    //线程不安全的list
    private ArrayList<String> array = new ArrayList<>();
    //独占锁
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    //添加元素
    public void add(String e){
        writeLock.lock();
        try {
            array.add(e);
        }finally {
            writeLock.unlock();
        }
    }

    //删除元素
    public void remove(String e){
        writeLock.lock();
        try {
            array.remove(e);
        }finally {
            writeLock.unlock();
        }
    }

    //读取数据
    public String get(int index){
        readLock.lock();
        try {
            return array.get(index);
        }finally {
            readLock.unlock();
        }
    }
}
