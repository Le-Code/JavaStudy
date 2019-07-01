package 注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * 使用注解定制序列化
 */
public class Main1 {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Label{
        String value() default " ";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    @interface Format{
        String pattern() default "yyyy-MM-dd HH:mm:ss";
        String timeZone() default "GMT+8";
    }

    static class Student{
        @Label("姓名")
        String name;
        @Label("年龄")
        int age;
        @Label("分数")
        double score;

        public Student() {
        }

        public Student(String name, int age, double score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }
    }

    public static void main(String[] args){
        Student student = new Student("张三", 12, 52d);
        String str = toString(student);
        System.out.println(str);
    }

    public static String toString(Object obj){
        try {
            StringBuilder sb = new StringBuilder();
            Class<?> cls = obj.getClass();
            Field[] fields = cls.getDeclaredFields();
            for (Field field:fields){
                if (!field.isAccessible())
                    field.setAccessible(true);
                Label annotation = field.getAnnotation(Label.class);
                String key = annotation==null?field.getName():annotation.value();
                Object value = field.get(obj);
                sb.append(key+"="+value+"\n");
            }
            return sb.toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
