package spring.demo2.CGLIB代理;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 在代理过程中不需要实现必须实现一个或者多个接口
 * 是一个代码生成包，对目标类生产一个子类，并对子类进行加强
 * spring集成了开发所需要的包
 */
public class CglibProxy implements MethodInterceptor {
    //代理方法
    public Object createProxy(Object target){
        //创建一个动态类对象
        Enhancer enhancer = new Enhancer();
        //确定需要增强的类，设置其父类
        enhancer.setSuperclass(target.getClass());
        //返回回掉函数
        enhancer.setCallback(this);
        //返回创建的代理类
        return enhancer.create();
    }

    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //创建切面对象
        MyAspect myAspect = new MyAspect();
        //前增强
        myAspect.check_permission();
        //目标方法执行
        Object obj = methodProxy.invokeSuper(proxy,args);
        //后增强
        myAspect.log();
        return obj;
    }
}
