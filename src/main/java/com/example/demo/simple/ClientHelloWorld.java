package com.example.demo.simple;

/**
 * @Author:zuohang
 * @date:2020/6/29 0029 20:42
 */


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Component;

@Component
public class ClientHelloWorld {
    private EventLoopGroup group=null;
    private Bootstrap bootstrap=null;
    public ClientHelloWorld(){
        init();
    }

    /**
     * 客户端初始化方法：
     */
    private void init() {
        group=new NioEventLoopGroup();
        bootstrap=new Bootstrap();
        bootstrap.group(group);
        bootstrap.channel(NioSocketChannel.class);

    }


    public ChannelFuture doRequest(String host,int port,final ChannelHandler... handlers) throws InterruptedException
    {
        this.bootstrap.handler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(handlers);

            }
        });
        ChannelFuture future=this.bootstrap.connect(host,port).sync();
        return future;
    }
    public void release(){
        this.group.shutdownGracefully();
    }

    /**
     * 客户端启动方法：
     */
    public void start(Integer integer) {
        ClientHelloWorld client=null;
        ChannelFuture future=null;
        try{
            client=new ClientHelloWorld();
            future=client.doRequest("localhost", 9999, new CliemtHelloWprldHandler());
            //Scanner s=null;

            future.channel().writeAndFlush(Unpooled.copiedBuffer(integer.toString().getBytes("UTF-8")));

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(null!=future)
            {
                try{
                    future.channel().closeFuture().sync();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            if(null != client)
            {
                client.release();
            }
        }
    }
}

