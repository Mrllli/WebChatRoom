package com.lhl.springboot.springbootdemo.netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

@Component
public class WebSocketServer {

    private static class SingletionWSServer{
        static final WebSocketServer instance = new WebSocketServer();
    }

    public static WebSocketServer getInstance(){
        return SingletionWSServer.instance;
    }

    private EventLoopGroup mainGroup;
    private EventLoopGroup subGroup;
    private ServerBootstrap server;
    private ChannelFuture future;

    public WebSocketServer(){
        //创建主从线程池
        mainGroup = new NioEventLoopGroup();
        subGroup = new NioEventLoopGroup();
        //创建服务类
        server = new ServerBootstrap();
        server.group(mainGroup,subGroup).channel(NioServerSocketChannel.class).childHandler(new WSServerInitializer());
    }
    public void start(){
        this.future = server.bind(8888);
        System.out.println("启动完毕.....");
        //future.channel().closeFuture().sync();
    }

}
