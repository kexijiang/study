package cn.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-25 20:51
 * 描述:
 */
public class NIOServerSocket {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);/*设置连接非阻塞*/
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));/*绑定端口*/
            while(true){
                SocketChannel socketChannel = serverSocketChannel.accept();/*获得一个客户端连接*/
                socketChannel.configureBlocking(false);/*设置io非阻塞*/
                Thread.sleep(1000);
                System.out.println("非阻塞");
                if(socketChannel!=null){
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    socketChannel.read(buffer);
                    System.out.println(new String(buffer.array()));
                    Thread.sleep(10000);
                    buffer.flip();/*反转*/
                    socketChannel.write(buffer);
                }else{
                    Thread.sleep(10000);
                    System.out.println("连接未就绪！");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
