package com.sxkl.netty.server;

import lombok.extern.slf4j.Slf4j;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.sxkl.netty.constant.Constants;
import com.sxkl.netty.data.SocketCache;
/** 
 *  
  * @ClassName: ServerHandler 
  * @Description: TODO 
  * @author xiefg 
  * @date 2016年8月4日 下午5:34:19 
  * 
 */  
@Slf4j
public class ServerHandler extends ChannelInboundHandlerAdapter {  
      
    public void channelRead(ChannelHandlerContext ctx, Object msg)  throws Exception {  
        if(msg.toString().startsWith(Constants.NAME_PRIFF_KEY)){
        	 SocketCache.getInstance().putSocket(msg.toString(),ctx);
        	 log.info("{}注册成功!",msg.toString());
        	 return;
        }
        log.info("server receive message : {}",msg);  
//        ctx.channel().writeAndFlush(uuid); 
    } 
    
    public void channelActive(ChannelHandlerContext ctx) throws Exception {  
        System.out.println("【channelActive】。。。");  
    }  

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
        System.out.println("【exception is general】");  
        System.out.println(cause.getMessage());
    }  
}  