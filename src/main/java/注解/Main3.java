package 注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用注解来实现单例模式
 */
public class Main3 {

    static Map<Class<?>, Object> instances = new HashMap<>();

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    @interface SimpleSingleton{
    }

    @SimpleSingleton
    static class ServiceB{
        public void action(){
            System.out.println("b action");
        }

    }

    public static <T> T getInstance(Class<T> cls){
        try {
            boolean singleton = cls.isAnnotationPresent(SimpleSingleton.class);
            if (!singleton){
                return createInstance(cls);
            }
            Object obj = instances.get(cls);
            if (obj!=null)
                return (T) obj;
            synchronized (cls){
                obj = instances.get(cls);
                if (obj==null) {
                    obj = createInstance(cls);
                    instances.put(cls, obj);
                }
            }
            return (T) obj;
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    private static <T> T createInstance(Class<T> cls) throws IllegalAccessException, InstantiationException {
        return cls.newInstance();
    }

    public static void main(String[] args){
        ServiceB serviceB = getInstance(ServiceB.class);
        System.out.println(serviceB);
        ServiceB serviceB1 = getInstance(ServiceB.class);
        System.out.println(serviceB1);

    }

}
