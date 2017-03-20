package com.fei.service;

import java.util.List;

import com.fei.domain.User;

/**
 * @author fei
 * @Time：2017年3月17日 下午4:07:27
 * @version 1.0
 */
public interface UserService {

	List<User> getAll();
	
	List<User> queryUserByName(String name);
	
	List<User> queryAll();
	
	
	List<User> queryListByPage(Integer page,Integer rows);
}
