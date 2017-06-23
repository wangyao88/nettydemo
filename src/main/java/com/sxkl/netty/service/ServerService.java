package com.sxkl.netty.service;

import lombok.extern.slf4j.Slf4j;
import io.netty.channel.ChannelHandlerContext;

import org.springframework.stereotype.Service;

import com.sxkl.netty.data.SocketCache;

@Slf4j
@Service
public class ServerService {
	
	public void sendMsg(){
		for(String key : SocketCache.getInstance().getSocketCache().keySet()){
			ChannelHandlerContext socket = SocketCache.getInstance().getSocket(key);
			log.info("send msg to {}",key);
			socket.writeAndFlush("sdfsdfd");
		}
	}
}
