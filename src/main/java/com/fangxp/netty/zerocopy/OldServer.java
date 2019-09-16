package com.fangxp.netty.zerocopy;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class OldServer {

    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(8899);

        while (true) {

            Socket accept = socket.accept();

            System.out.println("accept");

            DataInputStream dataInputStream = new DataInputStream(accept.getInputStream());

            while (true) {
                byte[] bytes = new byte[4096];

                int read = dataInputStream.read(bytes, 0, bytes.length);

                if (read == -1) {
                    break;
                }
            }

        }


    }


}
