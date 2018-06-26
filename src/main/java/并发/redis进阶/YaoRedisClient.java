package 并发.redis进阶;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class YaoRedisClient {

    private Socket socket;
    private final InputStream inputStream;
    private final OutputStream outputStream;

    public YaoRedisClient() throws IOException {
        socket = new Socket("127.0.0.1",6378);
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
    }

    //set hello yao
    public String set(String key,String value) throws IOException {
        StringBuffer command = new StringBuffer();
        command.append("*3").append("\r\n");
        command.append("$3").append("\r\n");
        command.append("SET").append("\r\n");
        //key的长度和值
        command.append("$").append(key.getBytes().length).append("\r\n");
        command.append(key).append("\r\n");
        command.append("$").append(value.getBytes().length).append("\r\n");
        command.append(value).append("\r\n");
        return execCommand(command);
    }

    //get hello
    public String get(String key) throws IOException {
        StringBuffer command = new StringBuffer();
        command.append("*2").append("\r\n");
        command.append("GET").append("\r\n");
        command.append("$").append(key.getBytes().length).append("\r\n");
        command.append(key).append("\r\n");
        return execCommand(command);
    }

    public String execCommand(StringBuffer command) throws IOException {
        //发送给server
        outputStream.write(command.toString().getBytes("utf-8"));
        outputStream.flush();
        outputStream.close();
        //接受返回
        byte[] b = new byte[1024];
        if (inputStream.read(b)==-1){
            throw new SocketException("没有数据返回");
        }
        return new String(b);
    }

}
