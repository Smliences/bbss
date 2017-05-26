package com.bbs.ssh.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.User;
import com.bbs.ssh.service.MuserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class MuserAction extends ActionSupport implements ModelDriven<User> {
	@Resource
	private MuserService muserService;
	private User user = new User();
	public User getModel() {
		return user;
	}
	
	public String ulist() throws Exception{
		List<User> ulist = muserService.findAll();
		List<Question> qlist = muserService.findQuestion();
		ActionContext.getContext().put("ulist", ulist);
		ActionContext.getContext().put("qlist", qlist);
		return "manager";
	}

}
