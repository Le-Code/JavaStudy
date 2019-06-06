package socket通信.单聊;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args){
        Socket socket = null;
        try {
            socket = new Socket(SocketUrls.IP,SocketUrls.PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String line = null;
                    while (true){
                        try {
                            if ((line = reader.readLine())!=null)
                                System.out.println(line);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }//获取服务器发来的消息

                    }
                }
            }).start();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我进来啦".getBytes("utf-8"));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
