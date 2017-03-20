package com.fei.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author fei
 * @Time：2017年3月17日 下午4:02:42
 * @version 1.0
 */
@Entity
public class User {
	@Id
	private Long id;
	private String userName;
	private String password;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", name=" + name + "]";
	}
	
}
