package com.fangxp.netty.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

public class StickyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

        int length = msg.readableBytes();
        byte[] bytes = new byte[length];

        msg.readBytes(bytes);

        String s = new String(bytes, Charset.forName("utf-8"));

        System.out.println("客户端接收到消息：" + s);

        System.out.println("消息次数" + (++this.count));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        for (int i = 0; i < 10; i++) {

            ctx.writeAndFlush(Unpooled.copiedBuffer("你好，中国", Charset.forName("utf-8")));
//            ctx.writeAndFlush("你好，中国");

        }

    }
}
