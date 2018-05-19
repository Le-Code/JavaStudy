package mybatis.demo1.mapper;

import mybatis.demo1.entity.User;

import java.util.List;

public interface UserMapper {
    User selectById(int id);
    void updateUser(User user);
    void delete(int id);
    void insertUser(User user);


}
