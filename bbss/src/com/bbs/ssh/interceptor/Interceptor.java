package com.bbs.ssh.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bbs.ssh.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class Interceptor extends MethodFilterInterceptor{

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("existUser");
		if(user!=null){
			return invocation.invoke();
		} else {
			request.setAttribute("registmessage", "你还未登陆");
			return "login";
		}
		
		
		
	}
	

}
