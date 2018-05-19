package mybatis.demo1.mapper;

import mybatis.demo1.entity.Order;

import java.util.List;

public interface OrderMapper {
    List<Order>getOrdersByUser(int userId);
}
