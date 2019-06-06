package 常用基础类.try_catch的return顺序问题;

public class Main {

    public static void main(String[] args){

//        System.out.println(f1());
//        System.out.println(f2(1,2));
//        System.out.println(f3());
//        System.out.println(f4());
        System.out.println(f5());
//        System.out.println(f6());
//        System.out.println(f7());
//        System.out.println(f8());
//        System.out.println(f9());
//        System.out.println(f10());
//        System.out.println(f11());
    }

    public static int f1(){
        try {
            System.out.println("try start");
            int a = 1/0;
            System.out.println("try error");
            return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }finally {
            System.out.println("finally");
            return 1;
        }
    }

    public static int f2(int a,int b){
        try {
            return a+b;
        }catch (Exception e){
            e.getMessage();
        }finally {
            System.out.println("执行finally");
            return a-b;
        }
    }

    public static int f3(){
        try {
            return 1;
        }catch (Exception e){
            e.getMessage();
            return 3;
        }finally {
            return 2;
        }
    }

    public static int f4(){
        int num = 10;
        try {
            num = 20;
            return num;
        }catch (Exception e){
            e.getMessage();
        }finally {
            num = 30;
//            return num;
        }
        System.out.println("haha");
        return num;
    }

    public static int f5(){
        int a = 1;
        try {
            return a+=1;
        }catch (Exception e){
            System.out.println("11");
        }finally {
            ++a;
            return a;
        }
    }

    public static int f6(){
        int a = 1;
        try {
            int u = 1/0;
        }catch (Exception e){
            System.out.println("11");
            return a;
        }finally {
            ++a;
        }
        return a;
    }

    public static int f7(){
        int a = 1;
        try {
            return a;
        } catch (Exception e) {
            System.out.println("11");

        } finally {
            ++a;
        }
        return a;
    }

    public static int f8(){
        int a = 1;
        try {
            int u = 1/0;
            return a;
        }catch (Exception e){
            System.out.println("11111");
            return a+1;
        }finally {
            ++a;
            System.out.println("22222");
        }
    }

    public static int f9(){
        int a = 1;
        try {
            int  u=1/0;
            return a;
        } catch (  ArithmeticException e) {
            System.out.println("11");
            return a+1;
        } catch (Exception e) {
            System.out.println("22");
            return a;
        }finally {
            ++a;
        }
    }

    public static int f10(){
        int i = 0;
        try {
            System.out.print("try\n");
            return i += 10;
        } catch (Exception e) {
            System.out.print("catch\n");
            i += 20;
        } finally {
            System.out.print("finally-i:"+i + "\n");
            i += 10;
            System.out.print("finally\n");
            //return i;
        }
        System.out.print("finish");
        return 200;
    }

    public static int f11(){
        int i = 0;
        try {
            System.out.print("try\n");
            return i += 10;
        } catch (Exception e) {
            System.out.print("catch\n");
            i += 20;
        } finally {
            System.out.print("finally-i:"+i + "\n");
            i += 10;
            System.out.print("finally\n");
            return i;
        }
    }
}
