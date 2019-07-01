package 动态代理.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理对象的优点
 * 可以利用同样的方法来获取代理对象
 */
public class Main2 {

    interface IServiceA{
        void sayHello();
    }

    interface IServiceB{
        void fly();
    }

    static class RealServiceA implements IServiceA{

        @Override
        public void sayHello() {
            System.out.println("realServiceA say hello");
        }
    }

    static class RealServiceB implements IServiceB{

        @Override
        public void fly() {
            System.out.println("realServiceB say hello");
        }
    }

    static class SimpleInvocationHandle implements InvocationHandler{

        private Object realObject;

        public SimpleInvocationHandle(Object realObject){
            this.realObject = realObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering " + method.getName());
            Object result = method.invoke(realObject, args);
            System.out.println("leaving " + method.getName());
            return result;
        }
    }

    public static <T> T getProxy(Class<T> cls, T realObj){
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new SimpleInvocationHandle(realObj));
    }

    public static void main(String[] args){

        IServiceA serviceA = new RealServiceA();
        IServiceA serviceAProxy = getProxy(IServiceA.class, serviceA);
        serviceAProxy.sayHello();
        IServiceB serviceB = new RealServiceB();
        IServiceB serviceBProxy = getProxy(IServiceB.class, serviceB);
        serviceBProxy.fly();

    }

}
