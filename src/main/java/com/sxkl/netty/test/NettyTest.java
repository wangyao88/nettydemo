package com.sxkl.netty.test;

import io.netty.channel.ChannelHandlerContext;

import com.sxkl.netty.client.NettyClient;
import com.sxkl.netty.data.SocketCache;

public class NettyTest {
	
	public static void main(String[] args) throws Exception {
		
		for(String key : SocketCache.getInstance().getSocketCache().keySet()){
			ChannelHandlerContext socket = SocketCache.getInstance().getSocket(key);
			socket.writeAndFlush("sdfsdfd");
		}
	}

}
