package com.bbs.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbs.ssh.dao.QuestionDao;
import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.Reply;

@Repository("questionDao")
public class QuestionDaoImpl implements QuestionDao{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void save(Question question) {
		hibernateTemplate.save(question);
	}
	public int findCount(){
		List<Object> list = (List<Object>)hibernateTemplate.find("select count(*) from Question");
	if(list!=null && list.size()!=0){
		Object obj = list.get(0);
		Long lobj = (Long)obj;
		int count = lobj.intValue();
		return count;
	}
	return 0;
	}
	public List<Question> findPage(int begin,int pageSize){
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		List<Question> list = (List<Question>)hibernateTemplate.findByCriteria(criteria,begin,pageSize);
		return list;
		}
	public Question findById(int qid) {
		List<Question> list = (List<Question>) hibernateTemplate.find("from Question where qid = ?", qid);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	public List<Reply> findByRid(int qid) {
		List<Reply> list = (List<Reply>) hibernateTemplate.find("from Reply where qid=? ", qid);
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}



}
