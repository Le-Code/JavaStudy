package spring.demo2.spring的AOP.基于代理类的aop实现;


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
