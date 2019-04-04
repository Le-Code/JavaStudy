package jvm.加载机制.初始化顺序.被动使用类字段1;

/**
 * 被动使用类字段1
 * 通过子类引用父类的静态字段，不会导致子类初始化
 */
public class NotInitialization {

    static {
        System.out.println("NotInitialization init");
    }


    public static void main(String[] args){
        /**
         * 代码只会输出SuperClass init,而不会输出SubClass init。
         * 对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类引用父类中定义的静态字段只会触发父类的初始化
         * @param args
         */
//        System.out.println(SubClass.value);
        /**
         * 此时这种方法并不会触发SuperClass的初始化阶段
         * 只是会触发一个名为 [jvm/加载机制/初始化顺序/被动使用类字段1/SuperClass的类的初始化阶段
         * 是一个由虚拟机自动生成的，直接继承与java.lang.Object的子类，创建动作由字节码指令newarray触发
         */
        SuperClass[] arr = new SuperClass[10];
    }

}
