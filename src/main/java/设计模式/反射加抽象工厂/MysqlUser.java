package 设计模式.反射加抽象工厂;

public class MysqlUser implements IUser {
    @Override
    public void insert(User user) {
        System.out.println("在mybatis中添加一个用户记录");
    }

    @Override
    public User getUserById(int id) {
        System.out.println("在mysql中根据id来查找一个user对象");
        return null;
    }
}
