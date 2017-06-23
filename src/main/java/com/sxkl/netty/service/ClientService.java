package com.sxkl.netty.service;

import org.springframework.stereotype.Service;

import com.sxkl.netty.client.NettyClient;
import com.sxkl.netty.constant.Constants;
import com.sxkl.netty.utils.UUIDUtil;


@Service
public class ClientService {
	
	public void sendMsg(){
		
	}
	
	public void registe(){
		for (int i = 0; i < 2; i++) {  
			String uuid = UUIDUtil.getUUID().toString();
            new Thread(new NettyClient(Constants.NAME_PRIFF_KEY+uuid)).start();  
        }  
	}

}
