package 设计模式.简单工厂模式;

public class OperationFactory {

    public static Operation getOperattion(char label){
        switch (label){
            case '+':return new OperationAdd();
            case '-':return new OperationSub();
            case '*':return new OperationMul();
            case '/':return new OperationDiv();
        }
        return null;
    }

}
