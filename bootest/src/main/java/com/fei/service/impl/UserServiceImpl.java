package com.fei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fei.dao.UserDao;
import com.fei.dao.UserMapper;
import com.fei.domain.User;
import com.fei.service.UserService;
import com.github.pagehelper.PageHelper;

/**
 * @author fei
 * @Time：2017年3月17日 下午4:08:54
 * @version 1.0 a.heicheapi.com
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getAll() {
		List<User> list = userDao.findAll();
		return list;
	}

	@Override
	public List<User> queryUserByName(String name) {

		return userMapper.queryUserByName(name);
	}

	@Override
	public List<User> queryAll() {
		return userMapper.queryAll();
	}

	@Override
	public List<User> queryListByPage(Integer page, Integer rows) {

		PageHelper.startPage(page, rows);

		return userMapper.select(null);
	}

}
