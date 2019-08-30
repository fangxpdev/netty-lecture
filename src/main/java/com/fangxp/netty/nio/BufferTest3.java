package com.fangxp.netty.nio;

import java.nio.ByteBuffer;

/**
 * readonly buffer
 */
public class BufferTest3 {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(10);

        System.out.println(buffer.getClass());

        for (int i = 0; i < 10; i++) {
            buffer.put((byte)i);
        }

        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        System.out.println(readOnlyBuffer.getClass());


    }


}
