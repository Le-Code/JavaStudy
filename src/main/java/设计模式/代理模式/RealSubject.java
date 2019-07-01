package 设计模式.代理模式;

public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("realSubject execute request method");
    }
}
