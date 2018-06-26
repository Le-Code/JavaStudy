package 并发.redis进阶;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RedisTest {

    @Test
    public void jedis(){
        //常用的客户端jedis
        Jedis jedis = new Jedis("127.0.0.1",6378);
        jedis.set("hello","yao");
        String value = jedis.get("hello");
        System.out.println(value);
        jedis.close();
    }

    @Test
    public void f() throws IOException {
        Socket socket = new Socket("127.0.0.1",6378);
        OutputStream os = socket.getOutputStream();
        os.write("123".getBytes());
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        inputStream.read(bytes);

    }
}
