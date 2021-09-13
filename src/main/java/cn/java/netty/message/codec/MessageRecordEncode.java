package cn.java.netty.message.codec;

import cn.hutool.log.Log;
import cn.java.netty.message.protocol.Header;
import cn.java.netty.message.protocol.MessageRecord;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.log4j.Log4j2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * 作者: Jiang
 * 时间: 2021/9/13
 * 描述: 消息编码类
 */

public class MessageRecordEncode extends MessageToByteEncoder<MessageRecord> {
    Log logger = Log.get();

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageRecord messageRecord, ByteBuf byteBuf) throws Exception {
        logger.info("=============开始进行消息编码============");
        Header header = messageRecord.getHeader();
        byteBuf.writeLong(header.getSessionId());
        byteBuf.writeByte(header.getReqType());


        Object body = messageRecord.getBody();
        if (body != null){
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(body);
            byte[] bytes = bos.toByteArray();
            byteBuf.writeInt(bytes.length);
            logger.info("=============消息编码结束============");
            byteBuf.writeBytes(bytes);
        }else{
            logger.info("消息长度为0");
        }
    }
}
