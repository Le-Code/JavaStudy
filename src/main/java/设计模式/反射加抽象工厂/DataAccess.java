package 设计模式.反射加抽象工厂;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class DataAccess {

    private static final String path = "设计模式.反射加抽象工程.";

    private static final String db = "Sqlserver";

    public static IUser createUser() throws Exception{
        String clazzPath = path+db+"User";
        Class clazz = Class.forName(clazzPath);
        Object obj = clazz.newInstance();
        return (IUser) obj;
    }

    public static IDepartment createDepartment() throws Exception{
        String clazzPath = path+db+"Department";
        Class clazz = Class.forName(clazzPath);
        Object obj = clazz.newInstance();
        return (IDepartment) obj;
    }

}
