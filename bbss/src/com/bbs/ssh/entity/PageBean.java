package com.bbs.ssh.entity;

import java.util.List;

public class PageBean {
	private Integer currentPage;
	private Integer totalCount;
	private Integer totalPage;
	private Integer pageSize;
	private Integer begin;
	private List<Question> list;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public List<Question> getList() {
		return list;
	}
	public void setList(List<Question> list) {
		this.list = list;
	}
	
}
