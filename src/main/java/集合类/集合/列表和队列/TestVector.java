package 集合类.集合.列表和队列;

import org.junit.Test;

import java.util.Vector;

public class TestVector {

    /**
     * 测试Vector所能存储的最大容量是否是Integer.MAX_VALUE
     */
    @Test
    public void testVectorCountOverIntegerMaxValue(){
        Long nums = Long.valueOf(Integer.MAX_VALUE);
        Vector<Integer> vec = new Vector<>();
        for (int i = 0; i < nums; i++){
            System.out.println(i);
            vec.add(0);
        }
    }

}
