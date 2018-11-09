package 设计模式.建造者模式;

public class ConcreteBuilder extends Builder {

    private Computer computer = new Computer();

    @Override
    public void buildCPU() {
        computer.addItem("cpu");
    }

    @Override
    public void buildHD() {
        computer.addItem("hd");
    }

    @Override
    public void buildKey() {
        computer.addItem("key");
    }

    @Override
    public Computer buildComputer() {
        return computer;
    }
}
