package com.fangxp.netty.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


public class NewIoServer {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket socket = serverSocketChannel.socket();
        socket.setReuseAddress(true);

        socket.bind(new InetSocketAddress(8899));


        while (true) {

            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);

            System.out.println("accpet");

            ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

            int readCount = 0;
            int read = 0;

            while (read != -1) {
                read = socketChannel.read(byteBuffer);
//                System.out.println("read:" + read);
                if (read != -1) {
                    readCount += read;
                }
                byteBuffer.rewind();
            }

            System.out.println("接收字节数：" + readCount);
        }

    }

}
