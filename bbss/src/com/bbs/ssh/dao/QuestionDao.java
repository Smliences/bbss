package com.bbs.ssh.dao;

import java.util.List;

import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.Reply;

public interface QuestionDao {

	void save(Question question);

	int findCount();

	List<Question> findPage(int begin, int pageSize);

	Question findById(int qid);

	List<Reply> findByRid(int qid);

}
