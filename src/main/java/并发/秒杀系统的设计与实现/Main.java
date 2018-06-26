package 并发.秒杀系统的设计与实现;

import jdk.nashorn.internal.parser.Token;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.util.concurrent.CountDownLatch;

public class Main {

    private MiaoshaService miaoshaService;

    private final int request_count = 2000;

    CountDownLatch cdl = new CountDownLatch(request_count);

    @Before
    public void start(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring//concurrent/demo1.xml");
        miaoshaService = (MiaoshaService) context.getBean("miaoshaService");
        //预先生成token
        Jedis jedis = new Jedis();
        for (int i = 0;i<100;i++){
            jedis.lpush("token_list",""+i);
        }
        jedis.close();
        System.out.println("令牌加载完毕");
        System.out.println("开始测试");
    }

    @After
    public void end(){
        System.out.println("结束测试："+(System.currentTimeMillis()-0));
    }

    @Test
    public void f() throws InterruptedException {
        Thread[] threads = new Thread[request_count];
        for (int i = 0;i<request_count;i++){
            Thread thread = new Thread(new UserRequest("yao_"+i));
            threads[i] = thread;
            thread.start();
            cdl.countDown();
        }
        for (int i = 0;i<request_count;i++)
            threads[i].join();

    }

    class UserRequest implements Runnable{

        private String username;

        public UserRequest(String username){
            this.username = username;
        }

        public void run() {
            try {
                cdl.await();//等待其他线程就绪
            }catch (Exception e){
                e.printStackTrace();
            }
            miaoshaService.miaosha(1,username);
        }
    }

    /**
     * 测试redis
     */
    @Test
    public void f1(){
        RedisCacheUtils utils = new RedisCacheUtils("127.0.0.1",6379);
        Jedis jedis = null;
        try{
            jedis = utils.getJedis();
            jedis.set("hello","","NX","EX",10);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null)
                jedis.close();
        }
    }
}
