package 设计模式.抽象工厂模式;

public class MysqlDepartment implements IDepartment {
    @Override
    public void insert(Department department) {
        System.out.println("在mybatis中添加一个部门记录");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("在mybatis中添加一个部门记录");
        return null;
    }
}
