package com.sxkl.netty.data;

import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class SocketCache {
	
	public Map<String,ChannelHandlerContext> socketCache = new HashMap<String,ChannelHandlerContext>();
	
	private SocketCache(){
		
	}
	
	private static class Singleton{
		private static final SocketCache socketCache = new SocketCache();
	}
	
	public static SocketCache getInstance(){
		return Singleton.socketCache;
	}
	
	public void putSocket(String msg,ChannelHandlerContext ctx){
		socketCache.put(msg, ctx);
	}
	
	public void remodeSocket(String msg){
		socketCache.remove(msg);
	}
	
	public ChannelHandlerContext getSocket(String msg){
		return socketCache.get(msg);
	}

}
