package spring.demo2.spring的AOP.基于代理类的aop实现;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {

    public void check_permission(){
        System.out.println("模拟检查权限");
    }

    public void log(){
        System.out.println("模拟记录日志");
    }

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        check_permission();
        //执行目标方法
        Object obj = methodInvocation.proceed();
        log();
        return obj;
    }
}
