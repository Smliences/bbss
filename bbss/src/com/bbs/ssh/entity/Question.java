package com.bbs.ssh.entity;



import java.util.HashSet;
import java.util.Set;


/**
 * Question entity. @author MyEclipse Persistence Tools
 */

public class Question  implements java.io.Serializable {


    // Fields    

     private Integer qid;
     private User user;
     private String title;
     private String content;
     private String wtime;
     private Set replies = new HashSet(0);


    // Constructors

    /** default constructor */
    public Question() {
    }

	/** minimal constructor */

    public Question(String title, String content, String wtime) {


        this.title = title;
        this.content = content;
        this.wtime = wtime;
    }
    
    /** full constructor */

    public Question(User user, String title, String content, String wtime, Set replies) {

        this.user = user;
        this.title = title;
        this.content = content;
        this.wtime = wtime;
        this.replies = replies;
    }

   
    // Property accessors

    public Integer getQid() {
        return this.qid;
    }
    
    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }


 

    public String getWtime() {
		return wtime;
	}

	public void setWtime(String wtime) {
		this.wtime = wtime;
	}

	public Set getReplies() {
        return this.replies;
    }
    
    public void setReplies(Set replies) {
        this.replies = replies;
    }

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", user=" + user + ", title=" + title
				+ ", content=" + content + ", wtime=" + wtime + ", replies="
				+ replies + "]";
	}
   








}