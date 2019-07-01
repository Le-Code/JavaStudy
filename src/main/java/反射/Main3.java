package 反射;

import java.lang.reflect.Method;

public class Main3 {

    static class RealService{
        public void sayHello(){
            System.out.println("say hello");
        }

        public int getSum(int a,int b){
            return a+b;
        }

        private void f1(){

        }

        private static void f2(){

        }

        public static void f3(){

        }

        public final void f4(){

        }

        private final void f5(){

        }
    }

    public static void main(String[] args){
        Class clazz = RealService.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods){
            System.out.println(method.getName());
        }
    }

}
