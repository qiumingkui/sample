package com.qiumingkui.sample.iwords.blog.domain.model.comment;

import java.sql.Timestamp;

public class CommentData {

	private String commentId;
	private String blogId;
	private String content;
	private Timestamp createTime;

	public CommentData(String commentId, String blogId, String content, Timestamp createTime) {
		super();
		this.commentId = commentId;
		this.blogId = blogId;
		this.content = content;
		this.createTime = createTime;
	}

	public String getCommentId() {
		return commentId;
	}

	public String getBlogId() {
		return blogId;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}
