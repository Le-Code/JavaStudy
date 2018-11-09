package 设计模式.建造者模式;

public class Main {

    public static void main(String[] args){

        Director director = new Director();
        Builder builder = new ConcreteBuilder();
        Computer computer = director.concrete(builder);
        computer.show();
    }


}
