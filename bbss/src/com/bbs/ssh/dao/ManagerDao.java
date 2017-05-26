package com.bbs.ssh.dao;

import java.util.List;

import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.User;

public interface ManagerDao {

	List<User> findUserAll();

	List<Question> findQuestionAll();

	void udelete(User user);


	User findByUid(int uid);

	Question findByQid(Integer qid);

	void qdelete(Question question);

	void uupdate(User user);

	void qupdate(Integer qid, String title, String wtime);

	User findByUser(User user);

}
