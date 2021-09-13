package cn.java.netty.message.client;

import cn.java.netty.message.codec.MessageRecordDecode;
import cn.java.netty.message.codec.MessageRecordEncode;
import cn.java.netty.message.opcode.OpCode;
import cn.java.netty.message.protocol.Header;
import cn.java.netty.message.protocol.MessageRecord;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.apache.ibatis.javassist.bytecode.Opcode;

import java.net.InetSocketAddress;

/**
 * 作者: Jiang
 * 时间: 2021/9/13
 * 描述:
 */
public class ProtocolClient {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup worker = new NioEventLoopGroup(4);
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel
                                .pipeline()
                                .addLast(new LengthFieldBasedFrameDecoder(1024*1024,
                                        9,
                                        4,
                                        0,
                                        0))
                                .addLast(new MessageRecordEncode())
                                .addLast(new MessageRecordDecode())
                                .addLast(new ClientHander());
                    }
                });
        ChannelFuture future = bootstrap.connect(new InetSocketAddress("localhost",8080)).sync();
        Channel channel = future.channel();
        for (int i = 0; i < 100; i++) {
            MessageRecord messageRecord = new MessageRecord();
            Header header = new Header();
            header.setSessionId(1232134);
            header.setReqType(OpCode.REQ.getCode());
            messageRecord.setHeader(header);
            String message = "hello ,我是第"+i+"条消息";
            messageRecord.setBody(message);
            channel.writeAndFlush(messageRecord);
        }
        try {
            channel.closeFuture().sync();//同步等待关闭future
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            worker.shutdownGracefully();
        }
    }
}
