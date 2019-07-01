package 设计模式.工厂模式;

public class OperationSubFactory implements IFactory {
    @Override
    public Operation getOperation() {
        return new OperationSub();
    }
}
