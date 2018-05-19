package mybatis.demo1;

import mybatis.demo1.entity.User;
import mybatis.demo1.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestUser {

    /**
     * 创建sqlSessionFactory的实例
     * @throws IOException
     */
    public SqlSessionFactory getSqlsessionFactory() throws IOException {
        String source = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void testSelectById() throws IOException {
        SqlSession session = getSqlsessionFactory().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testUpdate() throws IOException {
        SqlSession sqlSession = getSqlsessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(new User(1,"mary","123"));
        sqlSession.commit();
    }

    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = getSqlsessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insertUser(new User(0,"yaojian","0513"));
        sqlSession.commit();
    }

    @Test
    public void testDelete() throws IOException {
        SqlSession sqlSession = getSqlsessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.delete(1);
        sqlSession.commit();
    }

}
