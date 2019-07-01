package 设计模式.工厂模式;

public class OperationDivFactory implements IFactory {
    @Override
    public Operation getOperation() {
        return new OperationDiv();
    }
}
