package 设计模式.代理模式;

public class Proxy implements Subject {

    private Subject realSubject;

    public Proxy(Subject realSubject){
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("before realSubject execute request method");
        try {
            realSubject.request();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            System.out.println("after realSubject execute request method");
        }
    }
}
