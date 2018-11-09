package 类的扩展;

public class Outter {

    public static int num = 1;
    private static int num1 = 2;
    private int num3 = 3;
    public int num4 = 4;

    public static class InnerClass{
        public static int innerNum = 1;
        public void innerMethod(){
            System.out.println(num+num1);
            test2();
        }
    }

    public void test(){
        System.out.println("test");
    }

    public static void test2(){
        System.out.println("test2");
    }
}
