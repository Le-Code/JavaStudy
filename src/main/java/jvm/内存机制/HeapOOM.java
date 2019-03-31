package jvm.内存机制;

import java.util.ArrayList;
import java.util.List;

/**
 * 用来模拟java堆溢出
 * 限制java堆大小为20MB，且不可扩展（-Xms参数和-Xmx参数一样即可避免自动扩展
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }

}
