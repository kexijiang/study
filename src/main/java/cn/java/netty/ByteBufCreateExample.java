package cn.java.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;

import java.nio.ByteBuffer;

/**
 * 作者: Jiang
 * 时间: 2021/9/12
 * 描述:
 */
public class ByteBufCreateExample {
    public static void main(String[] args) {
        //堆内存，由JVM来管理内存
        ByteBuf buf =  ByteBufAllocator.DEFAULT.heapBuffer();
        //不是由JVM来管理，需要自己管理，存取效率会高一些
        ByteBufAllocator.DEFAULT.directBuffer();//堆外内存
        buf.writeByte(6);//byte占用一字节
        buf.writeByte(7);//byte占用一字节
        NettyByteBufExample.log(buf);
        System.out.println("开始进行读取操作");
        byte b = buf.readByte();//读取一个字节
        System.out.println(b);
        NettyByteBufExample.log(buf);
    }
}
