package com.fangxp.netty.handler;

import com.fangxp.netty.protobuf.ProtobufClientHandler;
import com.fangxp.netty.socket.MyClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class ProtocolClient {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
//                            pipeline.addLast(new ProtocolDecoder());
                            pipeline.addLast(new ProtocolDecoder2());
                            pipeline.addLast(new ProtocolEncoder());
                            pipeline.addLast(new ProtocolClientHandler());
                        }
                    });
            ChannelFuture channelFuture = b.connect("localhost", 8899).sync();
            channelFuture.channel().closeFuture().sync();

        } finally {
            group.shutdownGracefully();
        }
    }


}
