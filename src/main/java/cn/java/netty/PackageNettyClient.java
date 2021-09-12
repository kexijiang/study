package cn.java.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.StandardCharsets;

/**
 * 作者: Jiang
 * 时间: 2021/9/12
 * 描述: 客户端
 */
public class PackageNettyClient {
    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        ByteBuf buf = Unpooled.copiedBuffer("&".getBytes(StandardCharsets.UTF_8));
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
//                                .addLast(new FixedLengthFrameDecoder(36))
//                                .addLast(new DelimiterBasedFrameDecoder(10,true,true,buf))
                                .addLast(new LengthFieldPrepender(
                                        4,0,false))
                                .addLast(new StringEncoder())
//                                .addLast(new SimpleClientHandler());
                        .addLast(new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                ctx.writeAndFlush(Unpooled.copiedBuffer("i am first request".getBytes(StandardCharsets.UTF_8)));
                                ctx.writeAndFlush(Unpooled.copiedBuffer("i am second request".getBytes(StandardCharsets.UTF_8)));
//                                super.channelInactive(ctx);
                            }
                        });
                    }
                });
        try{
            ChannelFuture future = bootstrap.connect("localhost",8080).sync();
            future.channel().closeFuture().sync();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
