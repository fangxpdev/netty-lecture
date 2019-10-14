package com.fangxp.netty.custom;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;



public class CusProServerHandler extends SimpleChannelInboundHandler<FMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FMessage msg) throws Exception {
        System.out.println("服务端接受消息：" + msg);

    }


}
