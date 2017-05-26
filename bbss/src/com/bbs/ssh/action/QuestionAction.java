package com.bbs.ssh.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbs.ssh.entity.PageBean;
import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.Reply;
import com.bbs.ssh.entity.User;
import com.bbs.ssh.service.QuestionService;
import com.bbs.ssh.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("questionAction")
@Scope("prototype")
public class QuestionAction extends ActionSupport implements ModelDriven<Question>{
	@Resource
	private UserService userService;
	private Question question = new Question();
	private int currentPage;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	/*	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	@Resource
	private QuestionService questionService;
	public Question getModel() {
		return question;
	}
	public String save() throws Exception{
		long date = new Date().getTime();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String str = s.format(date);
		question.setWtime(str);
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		question.setUser(user);
		questionService.save(question);
		return "tomain";
	}
	
	public String listpage() throws Exception{
		PageBean pageBean = questionService.listpage(currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "main";
	}

	public String topostContent() throws Exception{
		int qid = question.getQid();
		Question existQuestion = questionService.findById(qid);
		ServletActionContext.getRequest().getSession().setAttribute("question", existQuestion);
		List<Reply> replyList = questionService.findByRid(qid);
		ServletActionContext.getContext().put("replyList", replyList);
		List<User> touserList =new ArrayList<User>();
		if(replyList!=null){
			//使用hashset去除重复数据,避免从数据库重复取出同一个用户的信息
			HashSet<Integer> hashSet = new HashSet<Integer>();
			for(int j=0;j<replyList.size();j++){
				Reply l = replyList.get(j);
				if(l.getTouser()!=null){
					hashSet.add(l.getTouser());
				}
			}
			Iterator<Integer> it = hashSet.iterator();
			while (it.hasNext()) {
				touserList.add(userService.findById(it.next()));
			}
		}
		ServletActionContext.getContext().put("touserList", touserList);
		
		return "postContent";
	}
	public String toposted() throws Exception{
		return "posted";
	}


}

/*if(list.size()==0){
		Reply reply = new Reply();
		reply.setContent("暂时没有用户评论");
		list.add(reply);
			ServletActionContext.getRequest().setAttribute("replyList", list);
		}*/