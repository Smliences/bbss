package com.bbs.ssh.dao;

import com.bbs.ssh.entity.User;

public interface UserDao {

	void save(User user);

	User findByNum(String num);

	User findByUser(User user);

	User findById(Integer id);
	
}
