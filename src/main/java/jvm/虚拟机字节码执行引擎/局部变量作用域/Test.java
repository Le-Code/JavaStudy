package jvm.虚拟机字节码执行引擎.局部变量作用域;

public class Test {

    /**
     * 测试局部变量是否会引起垃圾回收
     */
    public void test1(){
        byte[] placeholder = new byte[64*1024*1024];
        System.gc();
    }

    public void test2(){
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();
    }

    public void test3(){
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 1;
        System.gc();
    }

    public static void main(String[] args){

        Test test = new Test();
        test.test3();

    }

}
