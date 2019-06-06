package 反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 对于method的invoke方法，如果method为静态方法，obj被忽略,可以为null
 * */
public class Main {

    public static void main(String[] args){
        Class<Integer> integerClass = Integer.class;
        try {
            Method method = integerClass.getMethod("parseInt", new Class[]{String.class});
            System.out.println(method.invoke(null,"a23"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
