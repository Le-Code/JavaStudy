package 集合类.集合.Map和Set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetStudy {

    @Test
    public void test1(){
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("zhang");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
