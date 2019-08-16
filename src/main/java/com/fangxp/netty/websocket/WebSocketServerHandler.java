package com.fangxp.netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

public class WebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("收到客户端请求内容：" + msg.text());
        ctx.writeAndFlush(new TextWebSocketFrame(msg.text()));

    }


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded");
    }
}
