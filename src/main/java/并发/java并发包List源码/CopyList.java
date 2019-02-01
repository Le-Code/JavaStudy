package 并发.java并发包List源码;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 迭代器弱一致性的展示
 * 弱一致性：返回迭代器后，其他县城对list的增删改对迭代器是不可见的
 */
public class CopyList {

    public static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<String>();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("world");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hangzhou");

        Thread threadOne = new Thread(new Runnable() {
            public void run() {
                //修改list中的元素
                arrayList.set(1,"baba");
                //删除元素
                arrayList.remove(2);
                arrayList.remove(3);
            }
        });
        //保证在修改线程前启动迭代器
        Iterator<String> itr = arrayList.iterator();
        //启动线程
        threadOne.start();
        //等待子线程执行完毕
        threadOne.join();
        //迭代元素
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

    }

}
