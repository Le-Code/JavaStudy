package 反射;

import java.lang.reflect.Field;

public class Main2 {

    static class Student{
        String name;
        int age;
        double score;

        public Student() {
        }

        public Student(String name, int age, double score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", score=" + score +
                    '}';
        }
    }

    public static void main(String[] args){
        Student student = new Student("张三", 18, 89d);
        String str = toString(student);
        System.out.println(str);
        Student student1 = (Student) fromString(str);
        System.out.println(student1);
    }

    public static Object fromString(String str){
        try {
            String[] lines = str.split("\n");
            if (lines.length<1)
                throw new IllegalArgumentException(str);
            Class<?> cls = Class.forName(lines[0]);
            Object obj = cls.newInstance();
            if (lines.length>1){
                for (int i = 1; i<lines.length;i++){

                    String[] fv = lines[i].split("=");
                    if (fv.length<2)
                        throw new IllegalArgumentException(lines[i]);
                    Field field = cls.getDeclaredField(fv[0]);
                    if (!field.isAccessible())
                        field.setAccessible(true);
                    setFieldValue(field, obj, fv[1]);
                }
            }
            return obj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void setFieldValue(Field field, Object obj, String value) throws IllegalAccessException {
        Class<?> fieldType = field.getType();
        if (fieldType==int.class){
            field.setInt(obj, Integer.parseInt(value));
        }else if (fieldType==String.class){
            field.set(obj, value);
        }else if (fieldType==double.class){
            field.setDouble(obj, Double.parseDouble(value));
        }
    }

    public static String toString(Object obj){
        try {
            Class<?> objClass = obj.getClass();
            StringBuilder sb = new StringBuilder();
            sb.append(objClass.getName()+"\n");
            for (Field field:objClass.getDeclaredFields()){
                if (!field.isAccessible())
                    field.setAccessible(true);
                sb.append(field.getName()+"="+field.get(obj).toString()+"\n");
            }
            return sb.toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
