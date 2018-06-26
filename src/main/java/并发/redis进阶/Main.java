package 并发.redis进阶;

import org.junit.Test;

import java.io.IOException;

public class Main {

    @Test
    public void f() throws IOException {
        YaoRedisClient client = new YaoRedisClient();
        client.set("hello","yao");
        String value = client.get("hello");
        System.out.println("##############");
        System.out.println(value);
        System.out.println("##############");
    }
}
