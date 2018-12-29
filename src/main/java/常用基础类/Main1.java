package 常用基础类;

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.TreeSet;

public class Main1 {

    /**
     * 包装类和其对应的基本类型相互转换
     */
    @Test
    public void test1(){
        boolean b1 = false;
        Boolean bObj = Boolean.valueOf(b1);
        boolean b2 = bObj.booleanValue();
    }

    /**
     * 类的判断相等
     */
    @Test
    public void test2(){
        A a = new A(1);
        A a2 = new A(1);
        HashSet<A> hashSet = new HashSet<>();
        hashSet.add(a);hashSet.add(a2);
        System.out.println(a.equals(a2));
        System.out.println(a==a2);
        System.out.println(hashSet.size());
    }

    /**
     * 位移
     */
    @Test
    public void test3(){
        int a = 0x12345678;
        System.out.println(Integer.toBinaryString(a));
//        a = a>>>24;
//        System.out.println(Integer.toHexString(a));
        a = a>>>8;
        System.out.println(Integer.toHexString(a));
    }

    /**
     * 详细解刨character
     */
    @Test
    public void test4(){
        char[] chs = new char[3];
        chs[0] = '马';
        Character.toChars(0x1FFFF,chs,1);
        System.out.println(Character.codePointCount(chs,0,3));
        System.out.println(String.valueOf(chs));
        System.out.println(Character.toUpperCase(chs[0]));
        System.out.println(Character.toUpperCase('1'));
    }

    /**
     * 测试string
     */
    @Test
    public void test5(){
        //返回系统的默认编码
        System.out.println(Charset.defaultCharset().name());
    }

    class A {
        private int num;

        public A(int num){
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof A){
                A a = (A) obj;
                return a.getNum()==num;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return num;
        }

//        @Override
        /*public int compareTo(A o) {
            if (o.num==num)
                return 0;
            else if (o.num<num)
                return -1;
            return 1;
        }*/
    }



}
