package com.fei.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fei.domain.User;

/**
 * @author fei
 * @Time：2017年3月17日 下午4:06:08
 * @version 1.0
 */
public interface UserDao extends JpaRepository<User, Long>{

}
