package spring.demo2.CGLIB代理;

public class CglibTest {

//    @Test
    public void testProxy(){
        CglibProxy cglibProxy = new CglibProxy();
        UserDao userDao = new UserDao();
        UserDao userDao1 = (UserDao) cglibProxy.createProxy(userDao);
        userDao1.addUser();
        userDao1.deleteUser();
    }
}
