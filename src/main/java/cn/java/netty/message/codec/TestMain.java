package cn.java.netty.message.codec;

import cn.java.netty.message.codec.MessageRecordDecode;
import cn.java.netty.message.codec.MessageRecordEncode;
import cn.java.netty.message.opcode.OpCode;
import cn.java.netty.message.protocol.Header;
import cn.java.netty.message.protocol.MessageRecord;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;

/**
 * 作者: Jiang
 * 时间: 2021/9/13
 * 描述: 测试编码解码功能
 */
public class TestMain {
    public static void main(String[] args) throws Exception {
        EmbeddedChannel channel = new EmbeddedChannel(
                //长度域，可以知道一个完整的数据包是多长，从连接建立开始，到读取多长字节数据是一个完整的数据包
                new LengthFieldBasedFrameDecoder(1024*1024,
                        9,
                        4,
                        0,
                        0),
                new LoggingHandler(),
                new MessageRecordEncode(),
                new MessageRecordDecode()
        );

        Header header = new Header();
        header.setSessionId(123456);
        header.setReqType(OpCode.REQ.getCode());

        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setHeader(header);
        messageRecord.setBody("hello,world!");
//        channel.writeOutbound(header);//写出去，进行编码过程
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
        new MessageRecordEncode().encode(null,messageRecord,buf);


        //拆包过程 发送的时候，知道多少长度是一个完整的数据包
        ByteBuf bb1 = buf.slice(0,7);
        ByteBuf bb2 = buf.slice(7,buf.readableBytes()-7);
        bb1.retain();

        channel.writeInbound(bb1);
        channel.writeInbound(bb2);

    }
}
