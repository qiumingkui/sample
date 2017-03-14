package com.qiumingkui.ddd.sample.blog.domain.model;

import java.io.Serializable;

public class Comment implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CommentId commentId;
	
	private BlogId blogId;
	
	private Content content;

	private Comment() {
		super();
	}

	public Comment(CommentId commentId, BlogId blogId, Content content) {
		this();
		this.commentId = commentId;
		this.blogId = blogId;
		this.content = content;
	}

	public void changeContent(Content content) {
		this.setContent(content);
		
	}

	public CommentId commentId(){
		return this.commentId;
	}
	
	public BlogId blogId(){
		return this.blogId;
	}
	
	public Content content(){
		return this.content;
	}
	
	public void setCommentId(CommentId commentId) {
		this.commentId = commentId;
	}

	public void setBlogId(BlogId blogId) {
		this.blogId = blogId;
	}

	public void setContent(Content content) {
		this.content = content;
	}
	
	
	
}
