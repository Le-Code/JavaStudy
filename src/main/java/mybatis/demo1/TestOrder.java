package mybatis.demo1;

import mybatis.demo1.entity.Order;
import mybatis.demo1.mapper.OrderMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.weaver.ast.Or;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestOrder {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String source = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void getOrdersByUser() throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order>orders = mapper.getOrdersByUser(1);
        for (Order order:orders)
            System.out.println(order);
    }

}
