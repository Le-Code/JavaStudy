package 设计模式.抽象工厂模式;

public class SqlserverFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new SqlserverUser();
    }

    @Override
    public IDepartment creatDepartment() {
        return new SqlserverDepartment();
    }
}
