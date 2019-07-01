package 设计模式.反射加抽象工厂;

public class Main {

    /**
     * 在当前包下是不行的，因为我的包是中文
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        IUser user = DataAccess.createUser();
        user.insert(null);

        IDepartment department = DataAccess.createDepartment();
        department.insert(null);
    }
}
