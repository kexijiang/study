package cn.java.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 作者: Jiang
 * 时间: 2021/9/6
 * 描述:
 */
public class NettyExample {

    public static void main(String[] args) {
        //主线程数
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        //工作线程组
        EventLoopGroup workGroup = new NioEventLoopGroup(4);
        //服务端ServerBootstrap，客户端也有ServerBootstrap
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boosGroup,workGroup)
                //此处可以指定很多的Channel 也可以指定epoll模型
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline()
                        //多个Handler之间可以通过ChannelHandlerContext上下文类对象进行数据传输
                        //链式调用，可以进行一系列操作
                        //1.心跳
                        //2.编解码
                        //3.业务处理等等
                        .addLast(new NormalMessageHandler())
                .addLast(new ChannelInboundHandlerAdapter() {
                    @Override
                    public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

                    }
                });
            }
        });
        try {
            ChannelFuture channelFuture = bootstrap.bind(8080).sync();//同步阻塞等到客户端连接
            System.out.println("Netty Server Started SUccess:Listener port:8080");
            channelFuture.channel().closeFuture().sync();//同步等到服务端监听端口关闭
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            workGroup.shutdownGracefully();
            boosGroup.shutdownGracefully();
        }
    }
}
