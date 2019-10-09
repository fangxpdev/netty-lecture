package com.fangxp.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;


/**
 * 相对操作改变readIndex/writeIndex
 * 绝对操作不改变readIndex/writeIndex值
 */
public class ByteBufTest {


    public static void main(String[] args) {

        ByteBuf byteBuf = Unpooled.buffer(10);

        for (int i = 0; i < 10; i++) {
            byteBuf.writeByte(i);
        }


        //绝对操作
        for (int i = 0; i < byteBuf.capacity(); i++) {
            System.out.println(byteBuf.getByte(i));
        }

        //相对操作
        for (int i = 0; i < byteBuf.capacity(); i++) {
            System.out.println(byteBuf.readByte());
        }

    }

}
