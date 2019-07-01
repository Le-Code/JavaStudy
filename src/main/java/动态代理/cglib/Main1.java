package 动态代理.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理
 * javaSDK中的代理对象只能为接口创建代理，返回的代理对象也只能转换到某个接口类型
 */
public class Main1 {

    static class RealService{
        public void sayHello(){
            System.out.println("say hello");
        }

        public int getSum(int a,int b){
            return a+b;
        }

        private void f1(){

        }

        private static void f2(){

        }

        public static void f3(){

        }

        public final void f4(){

        }

        private final void f5(){

        }
    }

    static class SimpleInterceptor implements MethodInterceptor{

        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("entering " + method.getDeclaringClass());
//            Object result = methodProxy.invokeSuper(o, objects);
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("leaving " + method.getName());
            return result;
        }
    }

    public static <T> T getProxy(Class<T> cls){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new SimpleInterceptor());
        return (T) enhancer.create();
    }

    public static void main(String[] args){
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "com.yao.debugger");
        RealService realService = getProxy(RealService.class);
//        System.out.println(realService);
        realService.sayHello();

        int a = realService.getSum(1,2);
        System.out.println(a);
    }
}
