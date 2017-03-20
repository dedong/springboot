package com.fei.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.fei.domain.User;

/**
 * @author fei
 * @Time：2017年3月18日 下午1:07:42
 * @version 1.0
 */
@Mapper
public interface UserMapper extends com.github.abel533.mapper.Mapper<User>{

		@Select("select * from user where name like '%${value}%'")
		public List<User> queryUserByName(String name);
		
		
		public List<User> queryAll();
	
}
