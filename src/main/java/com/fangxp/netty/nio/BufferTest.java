package com.fangxp.netty.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class BufferTest {

    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(10);

        System.out.println(intBuffer.capacity() + "," + intBuffer.limit() + "," + intBuffer.position());

        for (int i = 0; i < intBuffer.capacity(); i++) {
            int nextInt = new SecureRandom().nextInt(20);
            intBuffer.put(nextInt);
        }
        System.out.println(intBuffer.capacity() + "," + intBuffer.limit() + "," + intBuffer.position());


        intBuffer.flip();

        System.out.println(intBuffer.capacity() + "," + intBuffer.limit() + "," + intBuffer.position());

        while (intBuffer.hasRemaining()) {
            int i = intBuffer.get();
            System.out.println(intBuffer.capacity() + "," + intBuffer.limit() + "," + intBuffer.position());
            System.out.println(i);
        }

    }


}
