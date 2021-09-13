package cn.java.netty.message.server;

import cn.hutool.log.Log;
import cn.java.netty.message.codec.MessageRecordDecode;
import cn.java.netty.message.codec.MessageRecordEncode;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 作者: Jiang
 * 时间: 2021/9/13
 * 描述:
 */
public class ProtocolServer {
    private final static Log logger = Log.get();
    public static void main(String[] args) {
        EventLoopGroup boos = new NioEventLoopGroup();
        EventLoopGroup word = new NioEventLoopGroup(4);
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boos,word)
                .channel(NioServerSocketChannel.class)//可能是工厂方法通过反射构建实例
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    //针对客户端连接来设置Pipeline
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024*1024,9,4,0,0))
                                .addLast(new MessageRecordEncode())
                                .addLast(new MessageRecordDecode())
                                .addLast(new ServerHander());
                    }
                });

        try {
            ChannelFuture future = bootstrap.bind(8080).sync();
            logger.info("server端初始化成功!");
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            boos.shutdownGracefully();
            word.shutdownGracefully();
        }

    }
}
