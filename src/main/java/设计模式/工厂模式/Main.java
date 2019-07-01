package 设计模式.工厂模式;

public class Main {
    public static void main(String[] args) {
        IFactory factory = new OperationDivFactory();
        Operation operation = factory.getOperation();
        System.out.println(operation.getResult(4,2));
    }
}
