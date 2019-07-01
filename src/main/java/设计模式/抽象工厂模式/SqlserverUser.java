package 设计模式.抽象工厂模式;

public class SqlserverUser implements IUser {
    @Override
    public void insert(User user) {
        System.out.println("在sqlserver中添加一个user对象");
    }

    @Override
    public User getUserById(int id) {
        System.out.println("在sqlserver中根据id查找一个user对象");
        return null;
    }
}
