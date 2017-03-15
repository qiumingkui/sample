package com.qiumingkui.ddd.sample.blog.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.ddd.sample.common.util.UtilDateTime;

public class Comment implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CommentId commentId;
	
	private BlogId blogId;
	
	private Content content;

	private Timestamp createTime;
	
	private Comment() {
		super();
	}

	public Comment(CommentId aCommentId, BlogId aBlogId, Content aContent) {
		this();
		
		this.setCommentId(aCommentId);
		this.setBlogId(aBlogId);
		this.setContent(aContent);
		this.setCreateTime(UtilDateTime.nowTimestamp());
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
	
	public Timestamp createTime() {
		return createTime;
	}

	private void setCommentId(CommentId commentId) {
		this.commentId = commentId;
	}

	private void setBlogId(BlogId blogId) {
		this.blogId = blogId;
	}

	private void setContent(Content content) {
		this.content = content;
	}

	private void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
}
