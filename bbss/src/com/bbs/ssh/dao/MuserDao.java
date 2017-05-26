package com.bbs.ssh.dao;

import java.util.List;

import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.User;

public interface MuserDao {

	List<User> findAll();

	List<Question> findQuestion();
	
}
