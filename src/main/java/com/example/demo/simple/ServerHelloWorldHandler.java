package com.example.demo.simple;

/**
 * @Author:zuohang
 * @date:2020/6/29 0029 20:47
 */

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Sharable表示此对象在channel间共享
 * handler类是我们的具体业务类
 * */
@Sharable//注解@Sharable可以让它在channels间共
public class ServerHelloWorldHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        ByteBuf readBuffer=(ByteBuf)msg;
        byte[] tmpeDatas=new byte[readBuffer.readableBytes()];
        readBuffer.readBytes(tmpeDatas);
        String message=new String(tmpeDatas,"UTF-8");
        System.out.println("from client:"+message);
        if("exit".equals(message))
        {
            ctx.close();
            System.out.println("连接关闭");
            return;
        }
        else{
            System.out.println("to client");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String line=br.readLine();
            ctx.writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        System.out.println("server excrptionCaughtvmethod run...");
        ctx.close();
    }

}


