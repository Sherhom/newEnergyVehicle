package com.nev.netty;

import java.sql.Timestamp;
import java.util.Date;

import com.nev.dao.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServerHandler extends ChannelInboundHandlerAdapter{
	
	private int counter;
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{

		String body = (String)msg;
		String[]message =  body.split("-");
		
		
		String currentTime = "Success";
		System.out.println(message[0]);
		System.out.println(message[1]);
		
		Dao dao = (Dao) Class.forName(message[0]).newInstance();
		dao.add(message, new Timestamp(System.currentTimeMillis()));
		
		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
		ctx.writeAndFlush(resp);
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx)throws Exception{
		ctx.flush();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx , Throwable cause){
		ctx.close();
	}
}
