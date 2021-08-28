package cn.java.redisclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-21 21:19
 * 描述:
 */
public class CustomerRedisClientSocket {
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public CustomerRedisClientSocket(String ip,int port){
        try{
            socket = new Socket(ip,port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void send(String cmd){
        try {
            outputStream.write(cmd.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String read(){
        byte[] bytes=new byte[1024];
        int count=0;
        try {
            count=inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes,0,count);
    }
}
