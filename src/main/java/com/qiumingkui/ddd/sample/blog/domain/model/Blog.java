package com.qiumingkui.ddd.sample.blog.domain.model;

import java.io.Serializable;

public class Blog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Blog() {
		super();
	}

	public Blog(BlogId aBlogId, Title aTitle, Content aContent) {
		this();
		this.setBlogId(aBlogId);
		this.setTitle(aTitle);
		this.setContent(aContent);
		this.setStatus(new BlogStatus(BlogStatus.ISSUE));
	}

	public Blog(BlogId aBlogId, Title aTitle, Content aContent, BlogStatus aStatus) {
		this(aBlogId,aTitle,aContent);
		this.setStatus(aStatus);
	}

	private BlogId blogId;

	private Title title;

	private Content content;

	private BlogStatus status;

	private int commentCount;

	private int readCount;

	public void changeTitle(Title aTitle) {
		setTitle(aTitle);
	}

	public void changeContent(Content aContent) {
		setContent(aContent);
	}

	public void changeCommentCount(int aCommentCount) {
		setCommentCount(aCommentCount);
	}

	public void changeReadCount(int aReadCount) {
		setReadCount(aReadCount);
	}

	public void reopen() {
		setStatus(new BlogStatus(BlogStatus.REOPEN));
	}

	public void lock() {
		setStatus(new BlogStatus(BlogStatus.LOCK));
	}

	public void close() {
		setStatus(new BlogStatus(BlogStatus.CLOSE));
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

	public BlogStatus status() {
		return status;
	}

	public int commentCount() {
		return commentCount;
	}

	public int readCount() {
		return readCount;
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

	private void setStatus(BlogStatus aStatus) {
		this.status = aStatus;
	}

	private void setCommentCount(int aCommentCount) {
		this.commentCount = aCommentCount;
	}

	private void setReadCount(int aReadTimes) {
		this.readCount = aReadTimes;
	}

}
