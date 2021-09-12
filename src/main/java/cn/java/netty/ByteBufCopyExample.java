package cn.java.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 作者: Jiang
 * 时间: 2021/9/12
 * 描述:
 */
public class ByteBufCopyExample {
    /*public static void main(String[] args) {
        //零拷贝机制
        ByteBuf buf =  ByteBufAllocator.DEFAULT.heapBuffer();
        buf.writeBytes(new byte[]{1,2,3,4,5,6,7,8,9,10});
        NettyByteBufExample.log(buf);
        //从buf这个总的数据中，分别拆分5个字节保存到两个ButeBuf中
        ByteBuf bufHeader = buf.slice(0,5);
        ByteBuf bufBody = buf.slice(5,5);
        NettyByteBufExample.log(bufHeader);
        NettyByteBufExample.log(bufBody);
        System.out.println("修改原始数据：");
        buf.setByte(2,8);
        NettyByteBufExample.log(bufHeader);
    }*/
    /*public static void main(String[] args) {
        //零拷贝机制
        ByteBuf header =  ByteBufAllocator.DEFAULT.heapBuffer();
        ByteBuf body =  ByteBufAllocator.DEFAULT.heapBuffer();
        header.writeBytes(new byte[]{1,2,3,4,5});
        body.writeBytes(new byte[]{6,7,8,9,10});
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();
        compositeByteBuf.addComponents(true,header,body);
        NettyByteBufExample.log(compositeByteBuf);
    }*/
    public static void main(String[] args) {
        //零拷贝机制
        ByteBuf header =  ByteBufAllocator.DEFAULT.heapBuffer();
        ByteBuf body =  ByteBufAllocator.DEFAULT.heapBuffer();
        header.writeBytes(new byte[]{1,2,3,4,5});
        body.writeBytes(new byte[]{6,7,8,9,10});
        ByteBuf total = Unpooled.wrappedBuffer(header,body);
        NettyByteBufExample.log(total);
        header.setByte(1,8);
        NettyByteBufExample.log(total);
    }
}
