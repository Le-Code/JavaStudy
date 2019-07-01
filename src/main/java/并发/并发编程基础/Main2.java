package 并发.并发编程基础;

/**
 * ThreadLocal使用示例
 */
public class Main2 {

    public static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void print(String str){
        System.out.println(str+":"+localVariable.get());
        localVariable.remove();
    }

    public static void main(String[] args){

        Thread threadOne = new Thread(){
            @Override
            public void run() {
                //设置的是线程本地内存中的一个副本
                localVariable.set("thread one");
                print("thread one");
                System.out.println("thread one after remove:"+localVariable.get());
            }
        };

        Thread threadTwo = new Thread(){
            @Override
            public void run() {
                localVariable.set("thread two");
                print("thread two");
                System.out.println("thread two after remove:"+localVariable.get());
            }
        };

        threadOne.start();
        threadTwo.start();
    }

}
