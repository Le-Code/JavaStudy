package spring.demo2.spring的AOP.基于注解方式的实现;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切面类，在此类中编写通知
 */

@Aspect//制定当前类为切面类
public class MyAspect {

    //定义切入点表达式
    @Pointcut("execution(* spring.demo2.spring的AOP.基于注解方式的实现.*.*(..))")
    //使用一个返回值为void,方法体为空的方法来命名切入点
    public void myPointCut(){}

    //前置通知
    @Before(value = "myPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知：模拟制定权限检查");
        System.out.println("目标类："+joinPoint.getTarget()+",被织入增强处理的目标方法为："+joinPoint.getSignature().getName());
    }

    //后置通知
    @AfterReturning(value = "myPointCut()",returning = "returning")
    public void afterReturn(JoinPoint joinPoint,int returning){
        System.out.println("后置通知：模拟记录日志");
        System.out.println("被织入增强的目标方法为："+joinPoint.getSignature().getName());
        System.out.println("返回的结果是："+returning);
    }

    //环绕增强
    @Around(value = "myPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕开始，执行目标方法之前，模拟开启事务");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("环绕结束，执行目标方法之后，模拟关闭事务");
        return obj;
    }

    //异常通知
    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Throwable e){
        System.out.println("一场通知，出错了，"+e.getMessage());
    }

    //最终通知
    @After(value = "myPointCut()")
    public void after(){
        System.out.println("最终通知：模拟方法结束后的释放资源...");
    }

}
