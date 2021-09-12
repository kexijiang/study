package cn.java.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * 作者: Jiang
 * 时间: 2021/9/12
 * 描述:
 */
public class SimpleClientHandler extends ChannelInboundHandlerAdapter {
    private int count;
    //连接建立成功
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接建立成功！");
        for (int i = 0; i < 40; i++) {
            ByteBuf buf = Unpooled.copiedBuffer("客户端消息："+i, Charset.forName("utf-8"));
            ctx.writeAndFlush(buf);
        }
        super.channelActive(ctx);
    }
    //读取数据
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到服务端返回的消息");
        ByteBuf buf = (ByteBuf) msg;
        byte[] data = new byte[buf.readableBytes()];
        buf.readBytes(data);
                String message = new String(data,Charset.defaultCharset());
        System.out.println("收到服务端的消息内容："+message);
        System.out.println("收到服务端的消息数量："+(++count));
        super.channelRead(ctx, msg);
    }
}
