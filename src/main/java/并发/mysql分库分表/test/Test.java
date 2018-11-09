package 并发.mysql分库分表.test;

public class Test {
    public static void main(String[] args){
        System.out.println("abc".hashCode()%1024);
    }
}
