package 设计模式.抽象工厂模式;

public class Main {
    public static void main(String[] args) {
        IFactory factory = new MysqlFactory();
        IUser user = factory.createUser();
        user.insert(null);

        IDepartment department = factory.creatDepartment();
        department.insert(null);
    }
}
