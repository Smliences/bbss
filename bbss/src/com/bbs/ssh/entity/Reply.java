package com.bbs.ssh.entity;

import com.bbs.ssh.entity.Question;



/**
 * Reply entity. @author MyEclipse Persistence Tools
 */

public class Reply  implements java.io.Serializable {


    // Fields    

     private Integer rid;
     private User user;
     private Question question;
     private Integer touser;
     private String content;
     private String rtime;
    /** default constructor */
    public Reply() {
    }

	/** minimal constructor */

    public Reply(User user, Question question, String content, String rtime) {

        this.user = user;
        this.question = question;
        this.content = content;
        this.rtime = rtime;
    }
    
    /** full constructor */

    public Reply(User user, Question question, Integer touser, String content, String rtime) {

        this.user = user;
        this.question = question;
        this.touser = touser;
        this.content = content;
        this.rtime = rtime;
    }

   
    // Property accessors

    public Integer getRid() {
        return this.rid;
    }
    
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return this.question;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }

    public Integer getTouser() {
        return this.touser;
    }
    
    public void setTouser(Integer touser) {
        this.touser = touser;
    }

   

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRtime() {
		return rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}










}