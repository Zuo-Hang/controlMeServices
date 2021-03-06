package com.example.demo.simple;

/**
 * @Author:zuohang
 * @date:2020/6/29 0029 20:45
 */

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class ServerHelloWorld {
    //监听线程组，监听客户端请求
    private EventLoopGroup acceptorGroup=null;
    //处理客户端相关操作线程组，负责处理与客户端的数据通讯
    private EventLoopGroup clientGroup=null;
    //服务启动先关配置信息
    private ServerBootstrap bootstrap=null;
    public ServerHelloWorld(){
        init();
    }
    private void init() {
        acceptorGroup=new NioEventLoopGroup();
        clientGroup=new NioEventLoopGroup();
        bootstrap=new ServerBootstrap();
        //绑定线程组
        bootstrap.group(acceptorGroup, clientGroup);
        //设定通讯模式为NIO
        bootstrap.channel(NioServerSocketChannel.class);
        //设定缓冲区大小
        bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        //SO_SNDBUF为发送缓冲区，SO_RCVBUF为接受缓冲区，SO_KEEPALIVE表示心跳检测，保证连接有效
        bootstrap.option(ChannelOption.SO_SNDBUF, 16*1024)
                .option(ChannelOption.SO_RCVBUF, 16*1024)
                .option(ChannelOption.SO_KEEPALIVE, true);

    }
    /*
     * childHandler是bootstrap独有的方法，是用于提供处理对象的
     * 可以一次性处理若干个请求，类似责任连模式的处理方式
     * 增加A.B离鞥个处理线程，在处理的时候按照顺序先运行A再运行B
     *
     * ChannelInitializer用于提供处理器的一个模拟对象
     * 其中定义了initChannel方法
     * 用于初始化逻辑责任链条的
     * 可以保证服务器的bootstrap只被初始化一次
     * */
    public ChannelFuture doAccept(int port,final ChannelHandler... acceptorHandlers) throws InterruptedException{
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(acceptorHandlers);
            }
        });
        ChannelFuture future=bootstrap.bind(port).sync();
        return future;}
    public void release(){
        this.acceptorGroup.shutdownGracefully();
        this.clientGroup.shutdownGracefully();
    }
    public void start() throws UnsupportedEncodingException {
        ChannelFuture future=null;
        ServerHelloWorld server=null;
        try{
            server=new ServerHelloWorld();
            future=server.doAccept(9999, new ServerHelloWorldHandler());
            System.out.println("server started:9999");

            future.channel().closeFuture().sync();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }finally
        {
            if(null != future)
            {
                try{
                    future.channel().closeFuture().sync();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            if(null != server)
            {
                server.release();
            }
        }
    }
}


