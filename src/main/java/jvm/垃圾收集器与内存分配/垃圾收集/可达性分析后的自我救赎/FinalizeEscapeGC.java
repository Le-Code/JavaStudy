package jvm.垃圾收集器与内存分配.垃圾收集.可达性分析后的自我救赎;

/**
 * 对象可以在GC时自我救赎
 * 这种自救的机会只有一次，因为一个对象的finalize方法最多只会被系统调用一次
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC save_hook = null;

    public void isAlive(){
        System.out.println("yes, i am still alive:");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.save_hook = this;
    }

    public static void main(String[] args) throws InterruptedException {
        save_hook = new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        save_hook = null;
        System.gc();
        Thread.sleep(500);

        if (save_hook!=null){
            save_hook.isAlive();
        }else{
            System.out.println("no i am died");
        }
        //同样的代码，第二次自救却失败了
        save_hook = null;
        System.gc();
        Thread.sleep(500);

        if (save_hook!=null){
            save_hook.isAlive();
        }else{
            System.out.println("no i am died");
        }
    }
}
