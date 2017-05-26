package com.bbs.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbs.ssh.dao.ManagerDao;
import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.User;

@Repository
public class ManagerDaoImpl implements ManagerDao{
	@Resource
	private HibernateTemplate hibernateTemplate;
	public List<User> findUserAll() {
		List<User> list = (List<User>) hibernateTemplate.find("from User");
		if(list!=null&&list.size()>0)
			return list;
		return null;
	}
	public List<Question> findQuestionAll() {
		List<Question> list = (List<Question>) hibernateTemplate.find("from Question");
		if(list!=null&&list.size()>0)
			return list;
		return null;
	}
	public void udelete(User user) {
		hibernateTemplate.delete(user);
	}
		
	public User findByUid(int uid) {
		List<User> list = (List<User>) hibernateTemplate.find("from User where uid=?", uid);
		if(list!=null&&list.size()>0)
		return list.get(0);
		return null;
	}
	public Question findByQid(Integer qid) {
		List<Question> list = (List<Question>) hibernateTemplate.find("from Question where qid=?",qid);
		if(list!=null&&list.size()>0)
			return list.get(0);
		return null;
	}
	public void qdelete(Question question) {
		hibernateTemplate.delete(question);
	}
	public void uupdate(User user) {
		hibernateTemplate.update(user);
	}
	public void qupdate(Integer qid, String title, String wtime) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery("update Question set title=?,wtime=? where qid=? ");
		query.setString(0, title);
		query.setString(1, wtime);
		query.setInteger(2, qid);
		query.executeUpdate();
		session.close();
		
	}
	public User findByUser(User user) {
		List<User> list = (List<User>) hibernateTemplate.find("from User where num=? and pwd=?", user.getNum(),user.getPwd());
		if(list!=null&&list.size()>0)
			return list.get(0);
		return null;
	}
	
}
