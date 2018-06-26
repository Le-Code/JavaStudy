package socket通信.上传文件;

import com.google.gson.Gson;
import socket通信.上传文件.entity.MessageBean;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatFileServer {
    /**
     * socket服务
     */
    private static ServerSocket server;
    public Gson gson = new Gson();

    /**
     * 初始化socket服务
     */
    public void initServer(){
        try {
            //创建一个server socket在端口8080监听客户请求
            server = new ServerSocket(SocketUrls.PORT);
            createMessage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 创建消息管理，一直接受消息
     */
    public void createMessage(){
        FileOutputStream fos = null;
        try {
            System.out.println("等待用户接入");
            //使用accept阻塞等待用户接入
            Socket socket = server.accept();
            System.out.println("用户接入："+socket.getPort());
            //开启一个子线程等待另外的socket接入
            new Thread(new Runnable() {
                public void run() {
                    //再次创建一个socket服务等待其他用户接入
                    createMessage();
                }
            }).start();
            //用于服务器推送消息给用户
            getMessage(socket);
            //从客户端获取信息
            InputStream is = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            //循环一直接受当前socket发来的消息
            while (true){
                Thread.sleep(500);
                int len = 0;
                byte[] b = new byte[1024];
                String json = null;
                while ((json = reader.readLine())!=null){
                    MessageBean messageBean = gson.fromJson(json,MessageBean.class);
                    //如果这不是一个文件消息，则不往下执行
                    if (messageBean.getChatFile()==null)
                        continue;
                    System.out.println("接收到的文件名："+messageBean.getChatFile().getFileName());
                    String fileNewName = messageBean.getChatFile().getFileName()+"."+messageBean.getChatFile().getFileTitle();
                    System.out.println("新生成的文件名："+fileNewName);
                    //1.创建空白文件对象
                    fos = new FileOutputStream("transFile\\"+fileNewName);
                    len = 0;
                    int fileSize = 0;
                    //2.把socket输入流写到文件输出流中
                    while ((len = is.read(b))!=-1){
                        fos.write(b,0,len);
                        fileSize+=len;
                        System.out.println("当前大小："+fileSize);
                        System.out.println("总大小："+messageBean.getChatFile().getFileLength());
                        //这里通过先前传过来的文件大小作为参考，因为文件流不能自主停止，所以通过判断文件大小跳出循环
                        if (fileSize==messageBean.getChatFile().getFileLength())
                            break;
                    }
                    fos.close();
                    System.out.println("文件保存成功");
                    System.out.println("用户："+messageBean.getFriendId());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误："+e.getMessage());
        }finally {
            CloseUtils.close(fos);
        }
    }

    /**
     * 发送消息
     * @param socket
     */
    private void getMessage(final Socket socket) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    String buffer;
                    while (true){
                        BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
                        buffer = strIn.readLine();
                        //因为readLine以换行符作为结束点，结尾加入换行
                        buffer+="\n";
                        //这里修改成想全部连接到服务器的用户发送消息
                        OutputStream os = socket.getOutputStream();
                        os.write(buffer.getBytes("utf-8"));
                        //发送数据
                        os.flush();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
