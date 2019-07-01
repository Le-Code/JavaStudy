package 设计模式.简单工厂模式;

public class Main {
    public static void main(String[] args) {
        Operation operation = OperationFactory.getOperattion('/');
        System.out.println(operation.getResult(6,2));
    }
}
