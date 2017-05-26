package com.bbs.ssh.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbs.ssh.entity.User;
import com.bbs.ssh.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	private String epwd;
	private String checkcode;
	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String getEpwd() {
		return epwd;
	}

	public void setEpwd(String epwd) {
		this.epwd = epwd;
	}

	@Resource
	private UserService userService;
	public User getModel() {
		return user;
	}
	
	public String regist() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String existcheckcode = (String) request.getSession().getAttribute("checkcode");
		if(!existcheckcode.equalsIgnoreCase(checkcode))
		{
			request.setAttribute("registmessage", "验证码不正确");
			return "register";
		}
		userService.save(user);
		request.setAttribute("registmessage", "注册成功");
		return "login";
	}
	
	public String findByName() throws Exception{
		User existuser = userService.findByNum(user.getNum());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(existuser!=null){
			response.getWriter().println("<font color='red'>手机账号已存在！</font>");
		}else {
			response.getWriter().println("<font color='green'>手机账号可以使用</font>");
		}
		return NONE;
	}
	public String login() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
//		String existcheckcode = (String) session.getAttribute("checkcode");
		User existUser = userService.findByUser(user);
	
		if(existUser!=null){
			session.setAttribute("existUser", existUser);
			return "index";
		}
		return "login";
		                               
	
}
}