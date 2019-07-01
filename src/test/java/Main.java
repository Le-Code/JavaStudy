import javax.management.monitor.Monitor;
import java.util.HashMap;
import java.util.Map;

public class Main{

    public static void main(String[] args){
//        f(6);
        f2();
    }

    public static void f2(){
        int i = 0;
//        retry:
        for (; i<10; i++){

            if (i==5) {
                continue;
            }
            System.out.println(i);
        }
    }

    public static void f(int num){
        switch (num){
            case 1:System.out.println("1");
            case 2:System.out.println("2");
            case 3:System.out.println("3");break;
            case 4:System.out.println("4");
            default:System.out.println("default");break;
        }

        int a = 1;
        int b = 2;
        if (a==1){
            a=2;
            b = 3;
        }else if (a==2){
            a=3;
        }else if (b==3) {
            a = 3;
            b = 4;
        }else{
            a=4;
        }
        System.out.println(a);
        System.out.println(b);

    }

}