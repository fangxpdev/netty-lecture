package com.fangxp.netty.zerocopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIoClient {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8899));
//        socketChannel.configureBlocking(true);

        long startTime = System.currentTimeMillis();

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        String fileName = "/Users/michael/Downloads/Parallels_Desktop_14.0.1.45154_TNT.dmg";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

//        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
//
//        int write = socketChannel.write(mappedByteBuffer);

        //零拷贝
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);


        System.out.println("发送总字节数："+transferCount+",耗时：" + (System.currentTimeMillis() - startTime));
    }


}
