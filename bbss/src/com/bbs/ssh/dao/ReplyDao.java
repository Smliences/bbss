package com.bbs.ssh.dao;

import java.util.List;

import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.Reply;
import com.bbs.ssh.entity.User;

public interface ReplyDao {

	void save(Reply reply);

	List<Reply> findByQid(int qid);

	Question findByQuestion(int qid);

	User findByUid(Integer touser);

	Reply findByTid(Integer touser);

	Reply findByRid(Integer rid, Integer integer);

}
