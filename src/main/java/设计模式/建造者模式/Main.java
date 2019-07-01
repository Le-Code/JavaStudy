package 设计模式.建造者模式;

public class Main {

    public static void main(String[] args) {
        PersonDirector personDirector = new PersonDirector(new PersonThinBuilder());
        personDirector.create();
    }

}
