package 线程.synchronized详解;

/**
 * 字节码的语义实现
 */
public class Demo5 {
    public int i;

    public void syncTask(){
        synchronized (this){
            i++;
        }
    }
}
