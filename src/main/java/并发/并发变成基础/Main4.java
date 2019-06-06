package 并发.并发变成基础;

import 集合类.泛型.Test;

/**
 * 测试在单线程下，连续地址的多个变量放到一个缓存行中对性能的影响
 */
public class Main4 {

    static final int Line_Num = 1024;
    static final int Colum_Num = 1024;

    public static void main(String[] args){
        TestContent1 testContent1 = new TestContent1();
        testContent1.test();
        TestContent2 testContent2 = new TestContent2();
        testContent2.test();
    }

    static class TestContent1{
        public void test(){
            int[][] arr = new int[Line_Num][Colum_Num];
            long startTime = System.currentTimeMillis();
            for (int i = 0;i<Line_Num;i++){
                for (int j = 0;j<Colum_Num;j++){
                    arr[i][j] = i*2+j;
                }
            }
            long endTime = System.currentTimeMillis();
            long cacheTime = endTime-startTime;
            System.out.println("testContent1 cache time:"+cacheTime);
        }
    }

    static class TestContent2{
        public void test(){
            int[][] arr = new int[Line_Num][Colum_Num];
            long startTime = System.currentTimeMillis();
            for (int i = 0;i<Line_Num;i++){
                for (int j = 0;j<Colum_Num;j++){
                    arr[j][i] = i*2+j;
                }
            }
            long endTime = System.currentTimeMillis();
            long cacheTime = endTime-startTime;
            System.out.println("testContent2 cache time:"+cacheTime);
        }
    }

}
