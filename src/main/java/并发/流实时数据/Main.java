package 并发.流实时数据;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * 初识流数据
     */
    @Test
    public void f(){
        List<Integer>list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(4);
        list.stream().sorted().forEach(System.out::println);
    }
}
