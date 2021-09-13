package cn.java.netty.message.client;

import cn.hutool.log.Log;
import cn.java.netty.message.protocol.MessageRecord;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;

/**
 * 作者: Jiang
 * 时间: 2021/9/13
 * 描述: 客户端数据处理类
 */
public class ClientHander extends ChannelInboundHandlerAdapter {
    private final static Log logger = Log.get();
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MessageRecord messageRecord = (MessageRecord)msg;
        logger.info("客户端收到消息："+messageRecord.toString());
        super.channelRead(ctx, msg);
    }
}
