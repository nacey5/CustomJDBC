package com.jdbc.core;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ClassName CustomClientHandler
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/29 21:40
 * @Version 0.0.1
 **/
public class CustomClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 在这里处理从服务器接收到的消息
        System.out.println("Received message from server: " + msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 在这里处理异常
        cause.printStackTrace();
        ctx.close();
    }
}
