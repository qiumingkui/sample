package com.qiumingkui.ddd.sample.blog.domain.model;

public class BlogData {

	private String blogId;

	private String title;

	private String content;

	
	
	public BlogData(String blogId, String title, String content) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.content = content;
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
	
	
}
