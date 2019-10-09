package com.fangxp.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 三种缓冲区类型：
 * 1、heap buffer
 * 2、direct buffer
 * 3、composite buffer 复合缓冲区
 *
 */
public class ByteBufTest3 {

    public static void main(String[] args) {

        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();

        ByteBuf heapBuf = Unpooled.buffer(10);
        ByteBuf directBuf = Unpooled.directBuffer(10);

        compositeByteBuf.addComponents(heapBuf, directBuf);

        compositeByteBuf.forEach(System.out::println);

    }

}
