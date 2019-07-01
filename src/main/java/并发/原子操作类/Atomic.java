package 并发.原子操作类;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 统计0的个数
 */
public class Atomic {

    //创建Long型原子计数器
    public static AtomicLong atomicLong = new AtomicLong();
//    public static int atomicLong = 0;
    //创建数据源
    private static Integer[] arrayOne = new Integer[]{0,1,2,3,0,5,6,0,56,0};
    private static Integer[] arrayTwo = new Integer[]{10,1,2,3,0,5,6,0,56,0};

    public static void total(Integer ...array){
        int size = array.length;
        for (int j = 0;j<100000;j++) {
            for (int i = 0; i < size; i++) {
                if (array[i] == 0)
                    atomicLong.incrementAndGet();
//                            atomicLong++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(){
            @Override
            public void run() {
                total(arrayOne);
            }
        };

        Thread threadTwo = new Thread(){
            @Override
            public void run() {
                total(arrayTwo);
            }
        };


        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("count 0：" + atomicLong.get());
    }

}
