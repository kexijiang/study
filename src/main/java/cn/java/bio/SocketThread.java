package cn.java.bio;


import java.io.*;
import java.net.Socket;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-25 20:42
 * 描述:
 */
public class SocketThread implements Runnable{

    private Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            /*socket.getInputStream()方法获取客户端中的请求报文信息*/
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientStr = bufferedReader.readLine();
            System.out.println("收到客户端发送的消息："+clientStr);
            /*创建发送的管道*/
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            /*写入给客户端的返回信息*/
            bufferedWriter.write("receive a message:"+clientStr+"\n");
            /*发送*/
            bufferedWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
