package com.fei.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fei.domain.User;
import com.fei.service.UserService;
import com.fei.utils.MailConfig;

/**
 * @author fei
 * @Time：2017年3月17日 下午4:44:17
 * @version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Resource
	private Environment env;
	
	@Resource
	private MailConfig mailConfig;
	
	@RequestMapping("list")
	public List<User> queryList(){
		return userService.getAll();
		
	}
	
	@RequestMapping("list/{name}")
	public List<User> queryListByName(@PathVariable String name){
		return userService.queryUserByName(name);
		
	}
	
	@RequestMapping("list/query")
	public List<User> queryAll(){
		
		System.out.println(env.getProperty("name"));
		System.out.println(env.getProperty("url"));
		return userService.queryAll();
	}
	
	/**
	 * queryByPage:(). 
	 * @author fei 
	 * @Time：2017年3月20日 下午5:56:50
	 * @param pageSize
	 * @param rownum
	 * @return
	 */
	@RequestMapping("list/{pageSize}/{rownum}")
	public List<User> queryByPage(@PathVariable Integer pageSize,@PathVariable Integer rownum){
		return userService.queryListByPage(pageSize, rownum);
		
	}
	
	@RequestMapping("mailInfo")
	public String mailInfo(){
		return mailConfig.getHost() + "<br>" + mailConfig.getPort() + "<br>" + mailConfig.getUsername()
		+ "<br>" + mailConfig.getPassword();
	}
}
