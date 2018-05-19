package spring.demo2.JDK动态代理;


import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {
    void add();
    void delete();
    void addUser(String method);
}
