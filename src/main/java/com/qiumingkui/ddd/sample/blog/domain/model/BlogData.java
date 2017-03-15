package com.qiumingkui.ddd.sample.blog.domain.model;

public class BlogData {

	private String blogId;

	private String title;

	private String content;
	
	private int status;

	
	
	public BlogData(String blogId, String title, String content, int status) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.content = content;
		this.status = status;
	}

	public String getBlogId() {
		return blogId;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
