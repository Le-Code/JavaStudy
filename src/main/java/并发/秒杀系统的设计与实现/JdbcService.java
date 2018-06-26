package 并发.秒杀系统的设计与实现;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JdbcService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public boolean buy(int id,String username){
        //数量减一
        //使用乐观锁，防止数据变成负的
        String sql = "update tb_num set num = num-1 where id = "+id+" and num-1>=0";
        int count = jdbcTemplate.update(sql);
        if (count!=1)
            //秒杀失败
            return false;
        //添加秒杀记录
        String insertSql = "insert into tb_order (username) values ('"+username+"')";
        int insertCount = jdbcTemplate.update(insertSql);
        if (insertCount!=1)
            return false;
        return true;
    }

}
