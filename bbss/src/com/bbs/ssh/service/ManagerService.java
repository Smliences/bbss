package com.bbs.ssh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.ssh.dao.ManagerDao;
import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.User;

@Transactional
@Service
public class ManagerService {
	@Resource
	private ManagerDao managerDao;

	public List<User> findUserAll() {
		return managerDao.findUserAll();
	}

	public List<Question> findQuestionAll() {
		return managerDao.findQuestionAll();
	}

	public void udelete(User user) {
		managerDao.udelete(user);
	}


	public User findByUid(Integer uid) {
		return managerDao.findByUid(uid);
	}

	public Question findByQid(Integer qid) {
		return managerDao.findByQid(qid);
	}

	public void qdelete(Question question) {
		managerDao.qdelete(question);
	}

	public void uupdate(User user) {
		managerDao.uupdate(user);
	}

	public void qupdate(Integer qid, String title, String wtime) {
		managerDao.qupdate(qid,title,wtime);
		
	}

	public User findByUser(User user) {
		return managerDao.findByUser(user);
	}
}
