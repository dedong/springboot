package com.fei.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
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
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public List<User> getAll() {
		List<User> list = userDao.findAll();
		return list;
	}

	@Override
	@CacheEvict(value="userCache",key="'user.queryAll'")
	public List<User> queryUserByName(String name) {
		
		this.redisTemplate.boundValueOps("bootRedis").set("boot 整合 redis");
		
		this.redisTemplate.boundValueOps("bootRedis").expire(100, TimeUnit.SECONDS);
		
		this.redisTemplate.boundValueOps("count").increment(1);
		
		System.out.println("缓存清理了！");
		return userMapper.queryUserByName(name);
	}

	@Override
	@Cacheable(value="userCache",key="'user.queryAll'")
	public List<User> queryAll() {
		System.out.println("从mysql中查询!");
		return userMapper.queryAll();
	}

	@Override
	public List<User> queryListByPage(Integer page, Integer rows) {

		PageHelper.startPage(page, rows);

		return userMapper.select(null);
	}

}
