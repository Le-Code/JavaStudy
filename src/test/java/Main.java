import java.util.HashMap;
import java.util.Map;

public class Main{

    public static void main(String[] args){
//        int[] arr = new int[5000000];
        Map<Integer,Integer>map = new HashMap<>();
        for (int i = 0;i<5000000;i++){
            map.put(i,i);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true);
            }
        }).start();
    }

}