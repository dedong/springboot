package com.fei.domain;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author fei
 * @Time：2017年5月2日 下午2:32:29
 * @version 1.0
 */
@Component
public class Consumer {

	@JmsListener(destination="fei.queue")
	public void receiveMessage(String message){
		System.out.println("接收到消息："+message);
	}
}
