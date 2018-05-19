package spring.demo2.JDK动态代理;

/**
 * 切面类，可以存在多个通知Advice（即增强的方法）
 */
public class MyAspect {
    public void check_permission(){
        System.out.println("模拟检查权限");
    }

    public void log(){
        System.out.println("模拟记录日志");
    }
}
