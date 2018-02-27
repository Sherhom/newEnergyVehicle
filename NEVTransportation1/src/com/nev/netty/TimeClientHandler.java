package com.nev.netty;

import java.util.logging.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientHandler extends ChannelInboundHandlerAdapter{
	
	private static final Logger logger = Logger.getLogger(TimeClientHandler.class.getName());
	
	//private final ByteBuf firstMessage;
	
	private int counter;
	
	private byte[] req;
	
	public TimeClientHandler(){
		//req = ("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes();
		req = ("22222-3333"+System.getProperty("line.separator")).getBytes();
		//firstMessage = Unpooled.buffer(req.length);
		//firstMessage.writeBytes(req);
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx){
		ByteBuf message = null;
		//for(int i = 0; i < 100; i++){
			message = Unpooled.buffer(req.length);
			message.writeBytes(req);
			ctx.writeAndFlush(message);
		//}
		//ctx.writeAndFlush(firstMessage);
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)throws Exception{
		//ByteBuf buf = (ByteBuf)msg;
		//byte[] req = new byte[buf.readableBytes()];
		//buf.readBytes(req);
		String body = (String)msg;
		System.out.println("Now is"+body+"; the counter is: " + ++counter);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
		//释放资源
		logger.warning("Unexpected exception from downstream:" + cause.getMessage());
		ctx.close();
	}
}
