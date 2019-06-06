package 注解;

import javax.xml.ws.Service;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Stack;

/**
 * 使用注解 DI容器
 */
public class Main2 {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface SimpleInject{

    }


    static class ServiceA{

        @SimpleInject
        ServiceB b;
        public void callB(){
            b.action();
        }
    }

    static class ServiceB{
        public void action(){
            System.out.println("b action");
        }
    }

    public static <T> T getInstance(Class<T> cls){
        try {
            T obj = cls.newInstance();
            Field[] fields = cls.getDeclaredFields();
            for (Field field:fields){
                if (field.isAnnotationPresent(SimpleInject.class)){
                    if (!field.isAccessible())
                        field.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    field.set(obj, getInstance(fieldType));
                }
            }
            return obj;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        ServiceA serviceA = getInstance(ServiceA.class);
        serviceA.callB();
    }

}
