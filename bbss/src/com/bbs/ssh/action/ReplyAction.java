package com.bbs.ssh.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbs.ssh.entity.Question;
import com.bbs.ssh.entity.Reply;
import com.bbs.ssh.entity.User;
import com.bbs.ssh.service.ReplyService;
import com.opensymphony.xwork2.ActionChainResult;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("replyAction")
@Scope("prototype")
public class ReplyAction extends ActionSupport implements ModelDriven<Reply>{
	private Reply reply = new Reply();

	@Resource
	private ReplyService replyService;
	public Reply getModel() {
		return reply;
	}
	public String save() throws Exception{
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		reply.setUser(user);
		
		long date = new Date().getTime();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String str = s.format(date);
		reply.setRtime(str);
		Question quesiton = (Question) ServletActionContext.getRequest().getSession().getAttribute("question");
		Question question = (Question) replyService.findByQuestion(quesiton.getQid());
		reply.setQuestion(question);
		replyService.save(reply);
		
//		if(reply.getTouser()!=null){
//			User existUser = replyService.findByUid(reply.getUser().getUid());
//			ServletActionContext.getRequest().setAttribute("existUser",existUser);
//			Integer rid = reply.getRid();
//			
//			Reply existReply = replyService.findByRid(rid,quesiton.getQid());
//			String content = existReply.getContent();
//			Integer tid = existReply.getTouser();
//			ServletActionContext.getRequest().setAttribute("tid", tid);
//			ServletActionContext.getRequest().setAttribute("content", content);
//		}
		return "topostcontent";
	}
/*	public String replyList() throws Exception{
		List<Reply> list = replyService.findByQid(qid);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "postcontent";
	}*/
}
