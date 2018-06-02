package socket通信.聊天消息推送;

import com.google.gson.Gson;
import socket通信.聊天消息推送.entity.MessageBean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * 聊天服务，最主要的一个程序
 */
public class ChatServer {

    /**
     * socket服务
     */
    private static ServerSocket server;

    public Gson gson = new Gson();

    /**
     * 初始化socket服务
     */
    public void initServer() {
        try {
            //创建一个ServerSocket再端口8888监听客户请求
            server = new ServerSocket(SocketUrls.PORT);
            createMessage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 创建消息管理，一直接收消息
     */
    private void createMessage() {
        try {
            System.out.println("等待用户接入：");
            //使用accept（）阻塞等待客户请求
            Socket socket = server.accept();
            System.out.println("用户接入："+socket.getPort());
            //开启一个子线程来等待另外的socket加入
            new Thread(new Runnable() {
                public void run() {
                    createMessage();
                }
            }).start();
            //向客户端发送消息
            final OutputStream output = socket.getOutputStream();
            //从客户端获取信息
            BufferedReader bff = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            new Thread(new Runnable() {
                public void run() {
                    try {
                        String buffer;
                        while (true){
                            //从控制台输入
                            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
                            buffer = strin.readLine();
                            //因为readLine以换行符为结束点，所以结尾加入换行
                            buffer+="\n";
                            output.write(buffer.getBytes("utf-8"));
                            //发送数据
                            output.flush();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
            //读取发来服务器的消息
            String line = null;
            //一直循环接收当前socket发送来的消息
            while (true){
                Thread.sleep(500);
                //获取客户端的信息
                while ((line = bff.readLine())!=null){
                    MessageBean messageBean = gson.fromJson(line,MessageBean.class);
                    System.out.println("用户："+messageBean);
                    System.out.println("内容"+messageBean.getContent());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误："+e.getMessage());
        }
    }
}
