package com.sxkl.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
/** 
 *  
  * @ClassName: Client 
  * @Description: TODO 
  * @author xiefg 
  * @date 2016年8月4日 下午6:18:08 
  * 
 */ 
@Data
@Slf4j
public class ClientHandler extends ChannelInboundHandlerAdapter {  
	
	private String name;
	
    public ClientHandler(String name) {
		this.name = name;
	}

	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {  
        log.info("client[{}] recivend msg : {}",this.getName(),msg.toString());
    }  

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
    	log.error("客户端发生错误!错误信息:{}",cause.getMessage());
    }  
}  
