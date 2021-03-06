package com.qiumingkui.sample.imedia.blog.domain.model.blogger;

public class BloggerBlogEntryVal {

	private int postNumber;
	
	private int commentNumber;
	
	private BloggerBlogEntryVal() {
		super();
	}

	public BloggerBlogEntryVal(int aPostNumber, int aCommentNumber) {
		this();
		this.setPostNumber(aPostNumber);
		this.setCommentNumber(aCommentNumber);
	}

	public int postNumber() {
		return postNumber;
	}

	public int commentNumber() {
		return commentNumber;
	}

	private void setPostNumber(int aPostNumber) {
		this.postNumber = aPostNumber;
	}

	private void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}

}
