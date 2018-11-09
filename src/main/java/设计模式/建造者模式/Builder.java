package 设计模式.建造者模式;

public abstract class Builder {

    public abstract void buildCPU();
    public abstract void buildHD();
    public abstract void buildKey();

    public abstract Computer buildComputer();

}
