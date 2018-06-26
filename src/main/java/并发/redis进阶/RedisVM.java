package 并发.redis进阶;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RedisVM {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6378);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        is.read(buffer);
        System.out.println(new String(buffer));
    }
}
