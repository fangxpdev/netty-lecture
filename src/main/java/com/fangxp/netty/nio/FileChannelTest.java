package com.fangxp.netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String[] args) throws Exception {


        FileInputStream fileInputStream = new FileInputStream("nioTest1.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(128);

        channel.read(buffer);

        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println((char)buffer.get());
        }

        fileInputStream.close();
        channel.close();

    }

}
