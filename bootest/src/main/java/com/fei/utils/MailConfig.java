package com.fei.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author fei
 * @Time：2017年5月2日 下午3:10:08
 * @version 1.0
 */

@Configuration
@ConfigurationProperties(locations="classpath:mail.properties",prefix="mail")
public class MailConfig {

	private String host;
	private Integer port;
	private String username; 
	private String password;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
