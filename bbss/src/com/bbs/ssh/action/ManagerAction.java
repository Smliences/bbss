package com.bbs.ssh.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.User;
import com.bbs.ssh.service.ManagerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class ManagerAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	private Integer qid;
	private String wtime;
	private String title;
	
	public String getWtime() {
		return wtime;
	}
	public void setWtime(String wtime) {
		this.wtime = wtime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	@Resource
	private ManagerService managerService;
	public User getModel() {
		return user;
	}
	public String login() throws Exception{
		User euser = managerService.findByUser(user);
		System.out.println(user);
		if(euser!=null&&euser.getRole().equals("管理员"))
		return "tomanager";
		return "managerlogin";
	}
	public String toList() throws Exception{
		List<User> ulist = managerService.findUserAll();
		List<Question> qlist = managerService.findQuestionAll();
		ActionContext.getContext().put("ulist", ulist);
		ActionContext.getContext().put("qlist",qlist);
		return "manager";
	}
	public String udelete() throws Exception{
		int uid = user.getUid();
		User euser = managerService.findByUid(uid);
		managerService.udelete(euser);
		return "tomanager";
	}
	public String qdelete() throws Exception{
		Question question = managerService.findByQid(qid);
		managerService.qdelete(question);
		return "tomanager";
	}
	public String toEdit() throws Exception{
		int uid = user.getUid();
		User euser = managerService.findByUid(uid);
		ActionContext.getContext().put("user", euser);
		return "edit";
	}
	public String toQuestion() throws Exception{
		Question question = managerService.findByQid(qid);
		ActionContext.getContext().put("question", question);
		return "question";
	}
	public String uupdate() throws Exception{
		managerService.uupdate(user);
		return "tomanager";
	}
	public String qupdate() throws Exception{
		System.out.println(qid+title+wtime);
		managerService.qupdate(qid,title,wtime);
		return "tomanager";
	}
}
