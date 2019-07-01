package 设计模式.工厂模式;

public class OperationDiv implements Operation {
    @Override
    public double getResult(int a, int b) {
        return a*1.0/b;
    }
}
