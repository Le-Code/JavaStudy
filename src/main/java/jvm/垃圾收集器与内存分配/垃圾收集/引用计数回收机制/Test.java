package jvm.垃圾收集器与内存分配.垃圾收集.引用计数回收机制;

public class Test {

    /**
     * 在vm options处加入-XX:+PrintGCDetails查看日志打印
     */
    @org.junit.Test
    public void test1(){
        ReferenceCountingGC.testGC();
    }

}
