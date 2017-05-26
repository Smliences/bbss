package com.bbs.ssh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.ssh.dao.MuserDao;
import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.User;

@Transactional
@Service
public class MuserService {
	@Resource
	private MuserDao muserDao;

	public List<User> findAll() {
		return muserDao.findAll();
	}

	public List<Question> findQuestion() {
		
		return muserDao.findQuestion();
	}
}
