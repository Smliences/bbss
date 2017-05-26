package com.bbs.ssh.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.ssh.dao.UserDao;
import com.bbs.ssh.entity.User;

@Service
@Transactional
public class UserService {
	@Resource
	private UserDao userDao;

	public void save(User user) {
		userDao.save(user);
	}

	public User findByNum(String num) {
		return userDao.findByNum(num);
	}

	public User findByUser(User user) {
		
		return userDao.findByUser(user);
	}
	public User findById(Integer id) {
		return userDao.findById(id);
		
	}
	
}
