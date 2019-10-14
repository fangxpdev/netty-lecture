package com.fangxp.netty.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

public class StickyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

        int length = msg.readableBytes();
        byte[] bytes = new byte[length];

        msg.readBytes(bytes);

        String s = new String(bytes, Charset.forName("utf-8"));

        System.out.println("服务端接收到消息：" + s);

        System.out.println("接受消息次数：" + (++this.count));

        ctx.writeAndFlush(Unpooled.copiedBuffer("你好，客户端", Charset.forName("utf-8")));

    }
}
