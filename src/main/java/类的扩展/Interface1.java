package 类的扩展;


public interface Interface1 {
    int a = 0;

    static void test(){
        System.out.println("hello test");
    }

    default void hi(){
        System.out.println("helli hi");
    }
}
