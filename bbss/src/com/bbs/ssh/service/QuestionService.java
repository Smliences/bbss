package com.bbs.ssh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.ssh.dao.QuestionDao;
import com.bbs.ssh.entity.PageBean;
import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.Reply;

@Transactional
@Service
public class QuestionService {
	@Resource
	private QuestionDao questionDao;
	public void save(Question question) {
		 questionDao.save(question);
	}

public PageBean listpage(Integer currentPage){
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		int totalCount = questionDao.findCount();
		pageBean.setTotalCount(totalCount);
		int pageSize = 5;
		int totalPage = 0;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		
		int begin = (currentPage-1)*pageSize;
		
		List<Question> list = questionDao.findPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

public Question findById(int qid) {
	
	return questionDao.findById(qid);
}

public List<Reply> findByRid(int qid) {
	
	return questionDao.findByRid(qid);
}
}
