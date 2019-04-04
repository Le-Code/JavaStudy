package jvm.垃圾收集器与内存分配.对象优先在Eden分配;

/**
 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * java堆大小20M,不可扩展，其中10M分给新生代，剩下的10M分给老年代
 * 新生代中Eden区与一个Survivor区的空间比例是8:1
 * 执行分配allocation4对象会发生一次Minor GC (新生代的垃圾收集动作）
 * 给allocation4分配内存时，Eden已经被占用了6MB内存，剩余的空间不足以分配4MB内存，因此发生Minor GC
 * GC期间3个2MB的对象全部无法放入Survivor空间（Survivor空间只有1MB）所以只好通过分配担保机制提前转移到老年代中
 */
public class Allocation {

    private static final int _1MB = 1024*1024;

    public static void testAllocation(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2*_1MB];
        allocation2 = new byte[2*_1MB];
        allocation3 = new byte[2*_1MB];
        allocation4 = new byte[4*_1MB];//出现一次Minor GC
    }

    public static void main(String[] args){
        Allocation.testAllocation();
    }

}
