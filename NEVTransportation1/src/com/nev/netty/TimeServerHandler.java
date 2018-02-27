package com.nev.netty;

import java.util.Date;

import com.nev.dao.LocationDao;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServerHandler extends ChannelInboundHandlerAdapter{
	
	private int counter;
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
		//ByteBuf buf = (ByteBuf)msg;
		//byte[] req = new byte[buf.readableBytes()];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		//buf.readBytes(req);
		String body = (String)msg;
		String[]message =  body.split("-");
		
		//System.out.println("The time server receive order:"+ body + " ;the counter is:"+ ++counter);
		//String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
		//currentTime = currentTime + System.getProperty("line.separator");
		String currentTime = "Success";
		System.out.println(message[0]);
		System.out.println(message[1]);
		new LocationDao().addDevice(message[0], message[1]);
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
