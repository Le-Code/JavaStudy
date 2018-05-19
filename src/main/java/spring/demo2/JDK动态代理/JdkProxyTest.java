package spring.demo2.JDK动态代理;

public class JdkProxyTest {

//    @Test
    public void testProxy(){
        //创建代理对象
        JdkProxy jdkProxy = new JdkProxy();
        //创建目标对象
        UserDao userDao = new UserDaoImpl();
        //从代理对象中获取增强后的目标对象
        UserDao userDao1 = (UserDao) jdkProxy.createProxy(userDao);
        //执行方法
        userDao1.addUser("张三");
        userDao1.delete();
    }
}
