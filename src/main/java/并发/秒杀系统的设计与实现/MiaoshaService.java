package 并发.秒杀系统的设计与实现;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class MiaoshaService {

    @Autowired
    JdbcService jdbcService;

    @Autowired
    RedisCacheUtils redisPool;

    public void miaosha(int id,String username){
        //码农通过脚本攻击url
        //限制用户操作频率，10s内只能操作一次
        //set setnx(不存在设置成功） setex（设置过期时间）
        Jedis jedis = redisPool.getJedis();
        String value = jedis.set(username,"","NX","EX",10);
        if (!"ok".equals(value)){
            System.out.println("被限制操作，用户："+username);
        }
        //数据库承受不住过大的请求量
        //拿到令牌，去操作数据
        String token = jedis.lpop("token_list");
        if (token==null||"".equals(token)){
            System.out.println("没抢到token,不参与秒杀，用户："+username);
            return;
        }
        boolean result = jdbcService.buy(id,username);
        System.out.println("秒杀结果："+result);
    }
}
