package 并发.redis进阶;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

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
        final Socket socket = new Socket("127.0.0.1",6378);
        OutputStream os = socket.getOutputStream();
        os.write("123".getBytes());

        new Thread(new Runnable() {
            public void run() {
                byte[] bytes = new byte[1024];
                InputStream inputStream = null;
                try {
                    inputStream = socket.getInputStream();
                    while (inputStream.read(bytes)!=-1){
                        System.out.println(new String(bytes));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
