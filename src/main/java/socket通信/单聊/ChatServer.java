package socket通信.单聊;

import com.google.gson.Gson;
import socket通信.单聊.entity.MessageBean;
import socket通信.单聊.entity.UserInfoBean;
import socket通信.聊天消息推送.SocketUrls;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 聊天服务，最主要的一个程序
 */
public class ChatServer {

    /**
     * socket服务
     */
    private static ServerSocket server;

    /**
     * 使用ArrayList 存储所有的socket地址
     */
    private List<Socket>socketList = new ArrayList<Socket>();
    /**
     * 模仿保存在内存中的socket
     */
    private Map<Integer,Socket>socketMap = new HashMap<Integer, Socket>();
    /**
     * 模仿保存在数据库中的用户信息
     */
    private Map<Integer,UserInfoBean>userMap = new HashMap<Integer, UserInfoBean>();
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
            //使用accept阻塞等待客户请求
            Socket socket = server.accept();
            //将链接进来的socket保存到集合中
            socketList.add(socket);
            //用户接入
            System.out.println("用户接入："+socket.getPort());
            //开启一个子线程等待另外的socket接入
            new Thread(new Runnable() {
                public void run() {
                    createMessage();
                }
            }).start();
            //用于服务器推送消息给用户
            getMessage();
            //从客户端获取信息
            BufferedReader bff = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //读取来自服务器消息
            String line = null;
            //循环一直接受当前socket发来的信息
            while (true){
                Thread.sleep(500);
                while ((line = bff.readLine())!=null){
                    //解析实体类
                    MessageBean messageBean = gson.fromJson(line,MessageBean.class);
                    //将用户信息添加到map中，模仿添加进数据库和内存
                    //实体类存入数据库，socket存入内存
                    setChatMap(messageBean,socket);
                    //将用户发送进来的消息转发给目标好友
                    getFriend(messageBean);
                    System.out.println("用户："+userMap.get(messageBean.getUserId()).getUserName());
                    System.out.println("内容："+messageBean.getContent());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误："+e.getMessage());
        }
    }

    /**
     * 模拟添加信息进入数据库和内存
     * @param messageBean
     */
    private void setChatMap(MessageBean messageBean,Socket socket) {
        //将用户信息存储
        if (userMap!=null&&userMap.get(messageBean.getUserId())==null){
            userMap.put(messageBean.getUserId(),getUserInfoBean(messageBean.getUserId()));
        }
        //将对应的连接进来的socket存储起来
        if (socketMap!=null&&socketMap.get(messageBean.getUserId())==null){
            socketMap.put(messageBean.getUserId(),socket);
        }
    }

    /**
     * 发送消息
     */
    private void getMessage() {
        new Thread(new Runnable() {
            public void run() {
                try{
                    String buffer;
                    while (true){
                        BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
                        buffer = strIn.readLine();
                        buffer+="\n";
                        //想所有连接到服务器的用户发送消息
                        for (Socket socket:socketMap.values()){
                            OutputStream output = socket.getOutputStream();
                            output.write(buffer.getBytes("utf-8"));
                            //发送数据
                            output.flush();
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("错误："+e.getMessage());
                }
            }
        }).start();
    }

    private UserInfoBean getUserInfoBean(int userId){
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.setUserIcon("用户头像");
        userInfoBean.setUserId(userId);
        userInfoBean.setUserName("admin");
        userInfoBean.setUserPwd("123");
        return userInfoBean;
    }

    /**
     * 将消息转发给目标好友
     * @param messageBean
     */
    private void getFriend(MessageBean messageBean){
        if (socketMap!=null&&socketMap.get(messageBean.getFriendId())!=null){
            Socket socket = socketMap.get(messageBean.getFriendId());
            String buffer = gson.toJson(messageBean);
            buffer+="\n";
            try {
                //向客户端发送消息
                OutputStream output = socket.getOutputStream();
                output.write(buffer.getBytes("utf-8"));
                output.flush();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}
