package 设计模式.抽象工厂模式;

public class SqlserverDepartment implements IDepartment {
    @Override
    public void insert(Department department) {
        System.out.println("在sqlserver中添加一个部门对象");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("在sqlserver中添加一个部门对象");
        return null;
    }
}
