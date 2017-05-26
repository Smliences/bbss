package com.bbs.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbs.ssh.dao.ReplyDao;
import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.Reply;
import com.bbs.ssh.entity.User;

@Repository("replyDao")
public class ReplyDaoImpl implements ReplyDao{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void save(Reply reply) {
		hibernateTemplate.save(reply);
	}

	public List<Reply> findByQid(int qid) {
		List<Reply> list = (List<Reply>) hibernateTemplate.find("from Reply where qid=?",qid);
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public Question findByQuestion(int qid) {
		List<Question> list = (List<Question>) hibernateTemplate.find("from Question where qid=?", qid);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public User findByUid(Integer touser) {
		List<User> list = (List<User>) hibernateTemplate.find("from User where uid=?", touser);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public Reply findByTid(Integer touser) {
		List<Reply> list = (List<Reply>) hibernateTemplate.find("from Reply where touser = ? ", touser);
		if(list!=null&&list.size()>0)
			return list.get(0);
		return null;
	}

	public Reply findByRid(Integer rid ,Integer integer) {
		List<Reply> list = (List<Reply>) hibernateTemplate.find("from Reply r where rid=?", rid);
		if(list!=null&&list.size()>0)
			return list.get(0);
		return null;
	}


	
}
