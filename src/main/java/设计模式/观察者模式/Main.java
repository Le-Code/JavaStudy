package 设计模式.观察者模式;

public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver("张三", subject));
        subject.subjectState = "我变了";
        subject.Notify();
    }
}
