package jvm.垃圾收集器与内存分配.垃圾收集.引用计数回收机制;

/**
 * 引用计数算法难以解决循环引用的方法，
 * ObjA 和 ObjB都有字段instance，赋值令objA.instance = objB.instance
 * 实际上这两个对象已经不可能再被访问，但是他们相互吸引对方导致引用计数都不为0
 * 无法通知GC收集器回收他们
 */
public class ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024*1024;

    private byte[] bigSize = new byte[2*_1MB];

    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }
}
