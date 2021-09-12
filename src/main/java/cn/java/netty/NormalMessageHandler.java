package cn.java.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 作者: Jiang
 * 时间: 2021/9/6
 * 描述:
 */
public class NormalMessageHandler extends ChannelInboundHandlerAdapter {
    /**
     * channel 注册到EventLoop时回调的方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }
    /**
     * channel 未注册到EventLoop或取消注册EventLoop时回调的方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }
    /**
     * channel 就绪，可以被读写
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        byte[] req = new byte[in.readableBytes()];
        in.readBytes(req);
        System.out.println("服务端收到的数据："+new String(req,"utf-8"));
        ByteBuf resp = Unpooled.copiedBuffer(("Server receive message success").getBytes());
        ctx.write(resp);
        super.channelRead(ctx, msg);
    }

    /**
     * channel读取完成回调的方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
                //立即关闭连接
                //.addListener(ChannelFutureListener.CLOSE);
        super.channelReadComplete(ctx);
    }

    /**
     * 捕获到异常回调的方法
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
