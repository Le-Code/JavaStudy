package jvm.垃圾收集器与内存分配.空间分配担保;

/**
 * Eden 回收不了的进入老年代
 * 老年代需要是否需要Full GC
 */
public class Allocation {

    private final static int _1MB = 1024*1024;

    public static void testHandlePromotion(){
        byte[] allocation1,allocation2,allocation3,allocation4,allocation5,allocation6,allocation7;
        allocation1 = new byte[2*_1MB];
        allocation2 = new byte[2*_1MB];
        allocation3 = new byte[2*_1MB];
        allocation1 = null;
        allocation4 = new byte[2*_1MB];
        allocation5 = new byte[2*_1MB];
        allocation6 = new byte[2*_1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2*_1MB];
    }

    public static void main(String[] args){
        Allocation.testHandlePromotion();
    }

}
