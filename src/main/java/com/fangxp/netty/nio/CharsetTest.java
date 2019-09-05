package com.fangxp.netty.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTest {


    public static void main(String[] args) throws IOException {

        RandomAccessFile inputFile = new RandomAccessFile("charsetInput.txt", "r");
        RandomAccessFile outputFile = new RandomAccessFile("charsetOutput.txt", "rw");

        long inputLength = inputFile.length();

        System.out.println(inputLength);

//        byte[] bytes = new byte[1024];
//        int read = (int) inputFile.read(bytes);
//
//        outputFile.write(bytes, 0, (int)inputLength);
//
//        inputFile.close();
//        outputFile.close();


        FileChannel inputChannel = inputFile.getChannel();
        FileChannel outputChannel = outputFile.getChannel();

        MappedByteBuffer inputData = inputChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputLength);

        //使用iso-8859-1 正常输出 不会乱码
        Charset charset = Charset.forName("utf-8");
        CharsetDecoder charsetDecoder = charset.newDecoder();
        CharsetEncoder charsetEncoder = charset.newEncoder();

        CharBuffer buffer = charsetDecoder.decode(inputData);

        outputChannel.write(charsetEncoder.encode(buffer));

        inputFile.close();
        outputFile.close();

    }

}
