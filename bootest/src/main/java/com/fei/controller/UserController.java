package com.fei.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fei.domain.User;
import com.fei.service.UserService;

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
}
