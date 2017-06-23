package com.sxkl.netty.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxkl.netty.service.ClientService;
import com.sxkl.netty.service.ServerService;

@Slf4j
@RestController
@RequestMapping(value="/netty")
public class NettyController {
	
	@Autowired
	private ServerService serverService;
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="/clientRegiste")
	public void clientRegiste(HttpServletResponse response){
		try {
			clientService.registe();
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			String result = "客户端注册成功";
			response.getWriter().write(result);
		} catch (IOException e) {
			log.error("客户端失败。错误信息{}",e.getMessage());
		}
	}

	@RequestMapping(value="/clientSendMsg")
	public void clientSendMsg(HttpServletResponse response){
		try {
			clientService.sendMsg();
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			String result = "发送消息成功";
			response.getWriter().write(result);
		} catch (IOException e) {
			log.error("发送消息失败。错误信息{}",e.getMessage());
		}
	}
	
	@RequestMapping(value="/serverSendMsg")
	public void serverSendMsg(HttpServletResponse response){
		try {
			serverService.sendMsg();
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			String result = "发送消息成功";
			response.getWriter().write(result);
		} catch (IOException e) {
			log.error("发送消息失败。错误信息{}",e.getMessage());
		}
	}
	
}
