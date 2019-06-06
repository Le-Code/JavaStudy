package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    interface IService{
        void sayHello();
    }

    static class RealService implements IService{
        @Override
        public void sayHello() {
            System.out.println("realService say hello");
        }
    }

    static class SimpleInvocationHandler implements InvocationHandler{

        private Object obj;

        public SimpleInvocationHandler(Object obj){
            this.obj = obj;
        }

        /**
         *
         * @param proxy 代理对象本身，注意它并不是被代理的对象，这个参数一般用处不大
         * @param method 表示正在被调用的方法
         * @param args 表示方法的参数
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering "+ method.getName());
            //注意不能将proxy作为参数传入invoke函数中，这样会造成死循环
            Object result = method.invoke(obj, args);
            System.out.println("leaving "+ method.getName());
            return result;
        }
    }

    public static void main(String[] args){
        IService service = new RealService();
        IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(), new Class[]{IService.class}, new SimpleInvocationHandler(service));
        proxyService.sayHello();
    }


}
