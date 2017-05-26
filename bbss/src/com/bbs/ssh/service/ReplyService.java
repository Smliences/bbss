package com.bbs.ssh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.ssh.dao.ReplyDao;
import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.Reply;
import com.bbs.ssh.entity.User;
@Transactional
@Service
public class ReplyService {
	@Resource
	private ReplyDao replyDao;

	public void save(Reply reply) {
		replyDao.save(reply);
	}

	public List<Reply> findByQid(int qid) {
		return replyDao.findByQid(qid);
	}

	public Question findByQuestion(int qid) {
		return replyDao.findByQuestion(qid);
	}

	public User findByUid(Integer touser) {
		
		return replyDao.findByUid(touser);
	}

	public Reply findByTid(Integer touser) {
		return replyDao.findByTid(touser);
	}

	public Reply findByRid(Integer rid, Integer integer) {
		
		return replyDao.findByRid(rid,integer);
	}
		
}
