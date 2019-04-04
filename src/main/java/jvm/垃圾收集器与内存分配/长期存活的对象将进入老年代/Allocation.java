package jvm.垃圾收集器与内存分配.长期存活的对象将进入老年代;

/**
 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
 * -XX:+PrintTenuringDistribution
 *
 */
public class Allocation {

    private final static int _1MB = 1024*1024;

    public static void testTenuringThreshold(){
        byte[] allocation1,allocation2,allocation3;
        allocation1 = new byte[_1MB/8];
        //什么时候进入老年代取决于-XX:MaxTenuringThreshold=1设置
        allocation2 = new byte[4*_1MB];
        allocation3 = new byte[4*_1MB];
        allocation3 = null;
        allocation3 = new byte[4*_1MB];
    }

    public static void main(String[] args){
        Allocation.testTenuringThreshold();
    }
}
