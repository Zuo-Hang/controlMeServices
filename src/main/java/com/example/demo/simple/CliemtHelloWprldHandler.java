package com.example.demo.simple;

/**
 * @Author:zuohang
 * @date:2020/6/29 0029 20:43
 */

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CliemtHelloWprldHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        try{ByteBuf readBuffer=(ByteBuf)msg;
            byte[] tempDatas=new byte[readBuffer.readableBytes()];
            readBuffer.readBytes(tempDatas);
            System.out.println("from server:"+new String(tempDatas,"UTF-8"));
            ctx.writeAndFlush(Unpooled.copiedBuffer(Unpooled.copiedBuffer("exit".getBytes("UTF-8"))));
        }
        finally{
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        System.out.println("client exceptionCanght method run...");
        ctx.close();
    }


}

