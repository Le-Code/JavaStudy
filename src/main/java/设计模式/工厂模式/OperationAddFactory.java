package 设计模式.工厂模式;

public class OperationAddFactory implements IFactory {
    @Override
    public Operation getOperation() {
        return new OperationAdd();
    }
}
