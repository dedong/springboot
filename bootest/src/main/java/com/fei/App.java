package com.fei;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 * @author fei
 * @Time：2017年3月17日 下午3:12:42
 * @version 1.0
 */
@SpringBootApplication
@EnableCaching
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("fei.queue");
	}
}
