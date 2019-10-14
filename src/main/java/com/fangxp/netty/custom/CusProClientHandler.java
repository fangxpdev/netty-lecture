package com.fangxp.netty.custom;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.Random;

public class CusProClientHandler extends SimpleChannelInboundHandler<FMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FMessage msg) throws Exception {
        System.out.println("客户端接受消息：" + msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            FMessage fMessage = new FMessage();
            String message = "我爱你" + new Random().nextInt(1000);
            FMessageHeader header = new FMessageHeader();
            header.setVersion(i);
            header.setContentLength(message.getBytes(Charset.forName("utf-8")).length);
            fMessage.setMessageHeader(header);
            fMessage.setContent(message);

            ctx.writeAndFlush(fMessage);
        }


    }


}
