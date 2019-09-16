package com.fangxp.netty.zerocopy;

import java.io.*;
import java.net.Socket;

public class OldClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8899);

        String fileName = "/Users/michael/Downloads/Parallels_Desktop_14.0.1.45154_TNT.dmg";

        long startTime = System.currentTimeMillis();

        InputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] bytes = new byte[4096];

        while (inputStream.read(bytes) >= 0) {
            dataOutputStream.write(bytes);
        }

        inputStream.close();
        dataOutputStream.close();
        socket.close();

        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));


    }


}
