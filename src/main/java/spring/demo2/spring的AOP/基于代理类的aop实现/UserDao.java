package spring.demo2.spring的AOP.基于代理类的aop实现;


import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {
    void add();
    void delete();
    void addUser(String method);
}
