package cn.java.netty.message.codec;

import cn.hutool.log.Log;
import cn.java.netty.message.protocol.Header;
import cn.java.netty.message.protocol.MessageRecord;
import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * 作者: Jiang
 * 时间: 2021/9/13
 * 描述: 消息解码类
 */

public class MessageRecordDecode extends ByteToMessageDecoder {
    Log logger = Log.get();
    // sessionId | reqType | Content-length | Content
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        MessageRecord messageRecord = new MessageRecord();
        //byteBuf 收到的消息报文
        Header header = new Header();
        header.setSessionId(byteBuf.readLong());//读取8个字节
        header.setReqType(byteBuf.readByte());//读取1个字节
        header.setLength(byteBuf.readInt());//读取4个字节，消息长度
        messageRecord.setHeader(header);
        //如果消息长度大于0
        if(header.getLength()>0){
            //读取到字节数组中
            byte[] contents = new byte[header.getLength()];
            byteBuf.readBytes(contents);
            //将读取的数据进行反序列化 java原生的对象流
            ByteArrayInputStream bis = new ByteArrayInputStream(contents);
            ObjectInputStream ios = new ObjectInputStream(bis);
            messageRecord.setBody(ios.readObject());
            logger.info("反序列化的结果："+ messageRecord.getBody().toString());
            list.add(messageRecord);
        }else{
            logger.info("消息内容为空！");
        }
    }
}
