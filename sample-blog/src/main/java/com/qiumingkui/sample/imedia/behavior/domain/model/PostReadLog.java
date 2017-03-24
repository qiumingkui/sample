package com.qiumingkui.sample.imedia.behavior.domain.model;

import java.sql.Timestamp;

public class PostReadLog {

	private String id;
	
	private String account;
	
	private String blogId;
	
	private Timestamp readTime;
	 

	private PostReadLog() {
		super();
	}

	public PostReadLog(String id, String account, String blogId, Timestamp readTime) {
		this();
		this.id = id;
		this.account = account;
		this.blogId = blogId;
		this.readTime = readTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public Timestamp getReadTime() {
		return readTime;
	}

	public void setReadTime(Timestamp readTime) {
		this.readTime = readTime;
	}
	
	
}
