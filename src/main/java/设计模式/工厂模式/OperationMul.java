package 设计模式.工厂模式;

public class OperationMul implements Operation {
    @Override
    public double getResult(int a, int b) {
        return a*b;
    }
}
