package 集合类.集合.Map和Set;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashMapStudy {
    @Test
    public void test1(){
        Map<String,String> map = new HashMap<>();
        map.put(null,"q23");
        System.out.println(map.get(null));
        int hashCode = 12>>>16;
        System.out.println(hashCode);
    }

    @Test
    public void test2(){
        HashMap<String,String> hashMap = new HashMap<>();
        System.out.println(hashMap.put("1","2"));
        System.out.println(hashMap.put("1","3"));
    }
}
