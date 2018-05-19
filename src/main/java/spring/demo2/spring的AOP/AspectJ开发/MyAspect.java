package spring.demo2.spring的AOP.AspectJ开发;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    //前置通知
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知：模拟制定权限检查");
        System.out.println("目标类："+joinPoint.getTarget()+",被织入增强处理的目标方法为："+joinPoint.getSignature().getName());
    }

    //后置增强
    public void afterReturn(JoinPoint joinPoint,int returnVal){
        System.out.println("后置通知：模拟记录日志");
        System.out.println("被织入增强的目标方法为："+joinPoint.getSignature().getName());
        System.out.println("执行后的结果是"+returnVal);
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint 是joinPoint的子类，表示可以执行目标方法，必须接受这个参数
     * @return
     */
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕开始，执行目标方法之前，模拟开启事务");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("环绕结束，执行目标方法之后，模拟关闭事务");
        return obj;
    }

    //异常通知
    public void afterThrowing(JoinPoint joinPoint,Throwable e){
        System.out.println("一场通知，出错了，"+e.getMessage());
    }

    //最终通知
    public void after(){
        System.out.println("最终通知：模拟方法结束后的释放资源...");
    }


}
