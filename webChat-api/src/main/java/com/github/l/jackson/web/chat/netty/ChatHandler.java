package com.github.l.jackson.web.chat.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import org.json.JSONObject;
import org.json.JSONArray;


import java.util.HashMap;

//用于处理消息，frame是消息的载体
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    //用于记录和管理所有客户端的channel
    private static ChannelGroup client = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        //获取消息
        String content = msg.text();
		String[] temp = content.split(":-");
		
		String name = temp[0];
		String messa = temp[1];
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		
		json.put("name",name);
		json.put("message",messa);
		
		array.put(json);
		
        //json.put("name":temp[0]);
		//json.put("msg":temp[1]);
		//System.out.println(json);
        client.writeAndFlush(
                new TextWebSocketFrame(
                        array.toString()
                ));

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        client.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        client.remove(ctx.channel());
        System.out.println("客户端断开:"+ctx.channel().id().asLongText());
    }
}
