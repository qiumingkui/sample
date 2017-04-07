package com.qiumingkui.sample.imedia.blog.domain.model.blogentry;

public class BlogEntryComment {
	private int commentNumber;

	private BlogEntryComment() {
		super();
	}

	public BlogEntryComment(int aCommentNumber) {
		this();
		this.setCommentNumber(aCommentNumber);
	}

	public int commentNumber() {
		return commentNumber;
	}

	private void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}	
	
}
