package com.bbs.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbs.ssh.dao.MuserDao;
import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.User;
@Repository("muserDao")
public class MuseraoImpl implements MuserDao{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public List<User> findAll() {
		List<User> list = (List<User>) hibernateTemplate.find("from User");
		if(list!=null&&list.size()>0)
			return list;
		return null;
	}

	public List<Question> findQuestion() {
		List<Question> list = (List<Question>) hibernateTemplate.find("from Question");
		if(list!=null&&list.size()>0)
			return list;
		return null;
	}

}
