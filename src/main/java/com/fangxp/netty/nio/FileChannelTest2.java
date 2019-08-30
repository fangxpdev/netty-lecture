package com.fangxp.netty.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest2 {

    public static void main(String[] args) throws Exception {

        FileOutputStream outputStream = new FileOutputStream("nioTest2.txt");
        FileChannel channel = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        byte[] bytes = "ni hao zhong guo".getBytes();

        for (int i = 0; i < bytes.length; i++) {
            buffer.put(bytes[i]);
        }

        buffer.flip();

        channel.write(buffer);

        outputStream.close();
        channel.close();


    }

}
