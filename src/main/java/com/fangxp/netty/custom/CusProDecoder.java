package com.fangxp.netty.custom;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;

public class CusProDecoder extends ByteToMessageDecoder {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        System.out.println("decode invoked!!!");

        if (in.readableBytes() < 8) {
            return;
        }

        int version = in.readInt();
        int contentLength = in.readInt();

        if (in.readableBytes() < contentLength) {

            in.setIndex(in.readerIndex() - 8, in.writerIndex());
            return;
        }

        byte[] content = new byte[contentLength];

        in.readBytes(content);

        String contentStr = new String(content, Charset.forName("utf-8"));

        FMessage message = new FMessage();
        FMessageHeader header = new FMessageHeader();
        header.setVersion(version);
        header.setContentLength(contentLength);
        message.setContent(contentStr);
        message.setMessageHeader(header);

        out.add(message);

    }
}
