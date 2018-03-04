package com.nev.netty;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nev.dao.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
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
		System.out.println("步骤0");
		//Dao dao = (Dao) Class.forName(message[0]).newInstance();
		//System.out.println("步骤1");
		//System.out.println(dao.toString());
		BatteryStatusDao dao = new BatteryStatusDao();
		Date date=new Date();                             
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        String date2=temp.format(date);  
        Date date3 = null;
		try {
			date3 = temp.parse(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		dao.add(message, new Timestamp(date3.getTime()));
		//System.out.println("步骤2");
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
