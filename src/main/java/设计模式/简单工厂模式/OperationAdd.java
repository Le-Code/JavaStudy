package 设计模式.简单工厂模式;

public class OperationAdd implements Operation{
    @Override
    public double getResult(int a, int b) {
        return a+b;
    }
}
