package listComprehension;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /**
     * 测试lumbda表达式
     * list的过滤和输出
     */
    @Test
    public void f(){
        ArrayList<String> list = new ArrayList<>();
        list.add("yao");
        list.add("jian");
        List<String>result;

        result = list.stream().filter((item)->item.equals("yao")).collect(Collectors.toList());

        result.forEach((item)->System.out.println(item));
    }

}
