package 设计模式.观察者模式;

public class ConcreteObserver extends Observer {

    private ConcreteSubject subject;

    private String name;

    public ConcreteObserver(String name,ConcreteSubject subject){
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        String subjectState = subject.subjectState;
        System.out.println("观察者 " + name+ "的新状态为 "+subjectState);
    }
}
