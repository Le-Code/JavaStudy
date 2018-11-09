package 设计模式.建造者模式;

/**
 * 指挥人员
 */
public class Director {
    public Computer concrete(Builder builder){
        builder.buildCPU();
        builder.buildHD();
        builder.buildKey();
        return builder.buildComputer();
    }
}
