package com.qiumingkui.ddd.sample.blog.domain.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class Blog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Blog() {
		super();
		this.setCommentIds(new HashSet<CommentId>());
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

	private Collection<CommentId> commentIds;

	public BlogId blogId() {
		return blogId;
	}

	public Title title() {
		return title;
	}

	public Content content() {
		return content;
	}

	public Collection<CommentId> commentIds() {
		return commentIds;
	}

	private void setBlogId(BlogId blogId) {
		this.blogId = blogId;
	}

	private void setTitle(Title title) {
		this.title = title;
	}

	private void setContent(Content content) {
		this.content = content;
	}

	private void setCommentIds(Collection<CommentId> commentIds) {
		this.commentIds = commentIds;
	}

}
