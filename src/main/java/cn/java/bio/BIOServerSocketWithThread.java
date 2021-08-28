package cn.java.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-25 20:27
 * 描述:
 */
public class BIOServerSocketWithThread {

    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        serverSocket = new ServerSocket(8080);
        System.out.println("启动服务，监听端口：8080");
        /*不断的监听客户端，每次循环都是一次通信过程，如果每次*/
        while(true){
            /*表示阻塞等待，监听一个客户端连接,socket表示连接的客户端的信息*/
            Socket socket = serverSocket.accept();//连接阻塞 //io阻塞
            /*打印客户端的请求端口*/
            System.out.println("客户端："+socket.getPort());
            /*异步丢给线程池*/
            executorService.submit(new SocketThread(socket));
        }

    }
}
