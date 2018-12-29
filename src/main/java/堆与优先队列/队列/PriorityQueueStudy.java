package 堆与优先队列.队列;

import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueStudy {

    /**
     * 元素从大到小排序
     */
    @Test
    public void test(){
        Queue<Integer> pq = new PriorityQueue<>();
        pq.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7}));

        while (pq.peek()!=null){
            System.out.println(pq.poll()+"");
        }
        Queue<Integer> qp = new PriorityQueue<>(11,Collections.reverseOrder());
        qp.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7}));
        while (qp.peek()!=null){
            System.out.println(qp.poll()+"");
        }
    }

    @Test
    public void test1(){
        byte a = -127;

        System.out.println((a<<1));
    }



}
