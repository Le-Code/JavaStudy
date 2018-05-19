package spring.demo2.JDK动态代理;


import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    public void add() {
        System.out.println("userDao  add method");
    }

    public void delete() {
        System.out.println("userDao delete method");
    }

    public void addUser(String method) {
        System.out.println("userDao add user"+method);
    }
}
