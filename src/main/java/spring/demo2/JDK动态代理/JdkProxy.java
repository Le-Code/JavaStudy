package spring.demo2.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk代理类
 * 使用过程必须实现一个或者多个接口
 */
public class JdkProxy implements InvocationHandler {

    //声明目标类接口
    private UserDao userDao;

    //创建代理方法
    public Object createProxy(UserDao userDao){
        this.userDao = userDao;
        //类加载器
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        //被代理对象实现的所有接口
        Class[] clazz = userDao.getClass().getInterfaces();
        //使用代理类进行增强，返回的是代理后的对象
        return Proxy.newProxyInstance(classLoader,clazz,this);
    }

    /**
     * 所有动态代理对象的方法调用都会交友invoke方法处理
     * @param proxy 被代理后的对象
     * @param method 将要被执行的方法信息
     * @param args 执行方法是需要的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //声明切面
        MyAspect myAspect = new MyAspect();
        //前增强
        myAspect.check_permission();
        //在目标类上调用方法，并传入参数
        Object obj = method.invoke(userDao,args);
        //后增强
        myAspect.log();
        return obj;
    }
}
