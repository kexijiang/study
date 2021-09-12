package cn.java.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.UUID;

/**
 * 作者: Jiang
 * 时间: 2021/9/12
 * 描述:
 */
public class SimpleServerHanler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        byte[] req = new byte[in.readableBytes()];
        in.readBytes(req);
        String body = new String(req,"utf-8");
        System.out.println("服务端收到的数据："+body);
        ByteBuf resp = Unpooled.copiedBuffer(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8));
        ctx.writeAndFlush(resp);
    }
}
