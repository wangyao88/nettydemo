package com.sxkl.netty.listener;

import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import lombok.extern.slf4j.Slf4j;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.sxkl.netty.server.NettyServer;
import com.sxkl.netty.utils.Configuration;


@Slf4j
public class StartSetverListener implements ServletContextListener{
	
	private ListeningExecutorService executorService;

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		int cpuCore = Runtime.getRuntime().availableProcessors();
		executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(cpuCore*2));
		executorService.submit(new Runnable() {
			public void run() {
				log.info("初始化配置文件...");
				Configuration.init();
				log.info("开始启动TCP服务器...");
				try {
					NettyServer.init();
				} catch (Exception e) {
					log.error("服务端启动失败.错误信息:{}",e.getMessage());
				}
			}
		});
	}

}
