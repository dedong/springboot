package com.fei.controller;

import javax.jms.Destination;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fei
 * @Time：2017年5月2日 下午2:20:47
 * @version 1.0
 */
@RestController
@RequestMapping("queue")
public class QueueController {

	/**
	 * 注入发送消息的对象
	 */
	@Autowired
	private JmsTemplate jmsTemplate;
	
	//注入消息队列
	@Autowired
	private Destination destination;
	
	@RequestMapping("send/{message}")
	public String send(@PathVariable String message){
		
		this.jmsTemplate.convertAndSend(destination, message);
		
		return "消息发送成功！发送了："+message;
	}
	
}
