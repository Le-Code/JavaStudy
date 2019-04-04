package jvm.JDK可视化工具;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用参数设置
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 * 使用jConsole测试内存监控
 */
public class Main {

    /**
     * 内存占位符，一个OOMObject大约占64KB
     */
    static class OOMObject{
        public byte[] placeHolder = new byte[64*1024];
    }

    /**
     * 以64KB/50ms的速度网java堆中填充数据，一共填充1000次，使用jConsole的“内存”页签进行监视
     * @param num
     * @throws InterruptedException
     */
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0;i<num;i++){
            Thread.sleep(500);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(100);
    }

}
