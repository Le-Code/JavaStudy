package 并发.秒杀系统的设计与实现;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisCacheUtils {

    private JedisPool pool;

    /**
     * 建立连接池，真实环境，配置参数抽取出来
     * @param host
     * @param port
     */
    public RedisCacheUtils(String host,int port){
        //建立连接池配置参数
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(10000);
        //设置最大阻塞时间 ，毫秒
        config.setMaxWaitMillis(10000);
        //设置空间连接,控制一个pool最多有多少个状态为idle的jedis实例
        config.setMaxIdle(100);
        pool = new JedisPool(config,host,port);
    }

    public Jedis getJedis(){
        if (pool!=null){
            return pool.getResource();
        }
        return null;
    }

}
