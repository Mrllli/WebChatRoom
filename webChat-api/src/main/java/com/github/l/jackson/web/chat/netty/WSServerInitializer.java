package com.github.l.jackson.web.chat.netty;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WSServerInitializer extends ChannelInitializer<SocketChannel> {


    protected void initChannel(SocketChannel channel) throws Exception {
        //获取管道
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast(new HttpServerCodec());//http编解码器

        pipeline.addLast(new ChunkedWriteHandler());//对数据流处理

        pipeline.addLast(new HttpObjectAggregator(1024*64));//聚合消息，生成request或者response

        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));//指定路由

        pipeline.addLast(new ChatHandler());//自定义handler处理
    }
}
