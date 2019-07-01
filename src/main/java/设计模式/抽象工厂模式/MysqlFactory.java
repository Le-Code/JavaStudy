package 设计模式.抽象工厂模式;

public class MysqlFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new MysqlUser();
    }

    @Override
    public IDepartment creatDepartment() {
        return new MysqlDepartment();
    }
}
