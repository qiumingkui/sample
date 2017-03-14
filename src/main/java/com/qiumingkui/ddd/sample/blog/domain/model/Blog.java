package com.qiumingkui.ddd.sample.blog.domain.model;

import java.io.Serializable;

public class Blog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Blog() {
		super();
		// this.setCommentIds(new HashSet<CommentId>());
	}

	public Blog(BlogId blogId, Title title, Content content) {
		this();
		this.setBlogId(blogId);
		this.setTitle(title);
		this.setContent(content);
	}

	private BlogId blogId;

	private Title title;

	private Content content;

	// private Collection<CommentId> commentIds;

	public void changeTitle(Title aTitle) {
		setTitle(aTitle);
	}

	public void changeContent(Content aContent){
		setContent(aContent);
	}
	
	public BlogId blogId() {
		return blogId;
	}

	public Title title() {
		return title;
	}

	public Content content() {
		return content;
	}

	private void setBlogId(BlogId aBlogId) {
		this.blogId = aBlogId;
	}

	private void setTitle(Title aTitle) {
		this.title = aTitle;
	}

	private void setContent(Content aContent) {
		this.content = aContent;
	}

}
