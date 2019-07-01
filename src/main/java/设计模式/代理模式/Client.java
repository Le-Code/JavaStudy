package 设计模式.代理模式;

public class Client {

    public static void main(String[] args){
        Subject proxy = new Proxy(new RealSubject());
        proxy.request();
    }

}
