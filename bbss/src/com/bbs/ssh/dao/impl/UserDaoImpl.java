package com.bbs.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbs.ssh.dao.UserDao;
import com.bbs.ssh.entity.User;
@Repository("userDao")
public class UserDaoImpl implements UserDao{
	@Resource
	private HibernateTemplate hibernateTemplate;

	

	public void save(User user) {
		hibernateTemplate.save(user);
		
	}


	public User findByNum(String num) {
		List<User> list = (List<User>) hibernateTemplate.find("from User where num=?", num);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}		
		return null;
	}

	public User findByUser(User user) {
		List<User> list = (List<User>) hibernateTemplate.find("from User where num=? and  pwd=?", user.getNum(),user.getPwd());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}		
		return null;
	}
	public User findById(Integer id) {
		User user =  hibernateTemplate.get(User.class, id);
		return user;
	}

}
