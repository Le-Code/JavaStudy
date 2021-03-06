package jvm.垃圾收集器与内存分配.内存机制;

/**
 * 虚拟机栈和本地方法栈OOM测试
 * 使用-Xss参数减少栈内存容量
 * -Xss128k
 */
public class JavaVMStackSOF {

    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args){
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:"+oom.stackLength);
            throw e;
        }
    }

}
