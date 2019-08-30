package com.fangxp.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferTest2 {

    public static void main(String[] args) throws Exception{

        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);
        int i =0;
        while (true) {
            i++;
//            buffer.clear(); //如果去除 clear 会导致无线读取buffer内容
            //{@link ReadableByteChannel read()} 读取的是buffer的remaining大小的
            System.out.println("remianing:" + buffer.remaining());
            int read = inputChannel.read(buffer);
            System.out.println("read:" + read);

            System.out.println("limit:" + buffer.limit() + ",position:" + buffer.position());
            if (read == -1) {
                break;
            }

            buffer.flip();
            System.out.println("limit:" + buffer.limit() + ",position:" + buffer.position());
            outputChannel.write(buffer);
            System.out.println("limit:" + buffer.limit() + ",position:" + buffer.position());

            if (i > 5) {
                break;
            }
        }

        inputChannel.close();
        outputChannel.close();

    }


}
