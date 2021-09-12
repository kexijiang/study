package cn.java.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;

import java.nio.charset.StandardCharsets;

/**
 * 作者: Jiang
 * 时间: 2021/9/12
 * 描述:
 */
public class NettyByteBufExample {
    public static void main(String[] args) {
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();//构建一个ByteBuf
        System.out.println("==========before==========");
        log(buf);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            str.append(","+i);
        }
        buf.writeBytes(str.toString().getBytes(StandardCharsets.UTF_8));
        System.out.println("==========after==========");
        log(buf);
    }
    public static void log (ByteBuf buf){
        StringBuilder sb = new StringBuilder();
        sb.append(" read index:").append(buf.readerIndex());//读索引
        sb.append(" write index:").append(buf.writerIndex());//写索引
        sb.append(" capacity  :").append(buf.capacity());//容量

        //将buf中的数据美化之后保存到sb中
        ByteBufUtil.appendPrettyHexDump(sb,buf);
        System.out.println(sb.toString());
    }
}
