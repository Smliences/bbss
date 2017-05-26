package com.bbs.ssh.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private Integer uid;
     private String num;
     private String pwd;
     private String name;
     private String role="普通用户";
     private Set replies = new HashSet(0);
     private Set questions = new HashSet(0);
     
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Set getReplies() {
		return replies;
	}
	public void setReplies(Set replies) {
		this.replies = replies;
	}
	public Set getQuestions() {
		return questions;
	}
	public void setQuestions(Set questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", num=" + num + ", pwd=" + pwd + ", name="
				+ name + ", replies=" + replies + ", questions=" + questions
				+ "]";
	}
     
     
}