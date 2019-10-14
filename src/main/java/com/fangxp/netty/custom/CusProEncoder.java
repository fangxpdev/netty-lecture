package com.fangxp.netty.custom;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

public class CusProEncoder extends MessageToByteEncoder<FMessage> {

    @Override
    protected void encode(ChannelHandlerContext ctx, FMessage msg, ByteBuf out) throws Exception {
        System.out.println("encode invoked!!!");

        int version = msg.getMessageHeader().getVersion();
        int contentLength = msg.getMessageHeader().getContentLength();

        String content = msg.getContent();

        out.writeInt(version);
        out.writeInt(contentLength);
        out.writeBytes(content.getBytes(Charset.forName("utf-8")));

    }

}
