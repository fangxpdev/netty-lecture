package com.fangxp.netty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CmdTest {

    public static void main(String[] args) throws InterruptedException, IOException {

        String[] cmds = {"/bin/sh","-c","ps -ef|grep java"};
        Process pro = Runtime.getRuntime().exec(cmds);
        pro.waitFor();
        InputStream in = pro.getInputStream();
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while((line = read.readLine())!=null){
            System.out.println(line);
        }


    }

}
