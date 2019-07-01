package 设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象通知者
 */
public abstract class Subject {

    private List<Observer> observers;

    public Subject(){
        observers = new ArrayList<>();
    }

    public void attach(Observer observer){
        this.observers.add(observer);
    }

    public void detach(Observer observer){
        this.observers.remove(observer);
    }

    public void Notify(){
        for (Observer observer:observers) {
            observer.update();
        }
    }

}
