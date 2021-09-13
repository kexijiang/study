package cn.java.netty.message.server;

import cn.hutool.log.Log;
import cn.java.netty.message.opcode.OpCode;
import cn.java.netty.message.protocol.MessageRecord;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 作者: Jiang
 * 时间: 2021/9/13
 * 描述:
 */
public class ServerHander extends ChannelInboundHandlerAdapter {
    private final static Log logger = Log.get();
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MessageRecord record = (MessageRecord)msg;
        logger.info("服务端收到消息："+record);
        record.setBody("你好，服务端正在处理请求！");
        record.getHeader().setReqType(OpCode.RES.getCode());
        ctx.writeAndFlush(record);
//        super.channelRead(ctx, msg);
    }
}
