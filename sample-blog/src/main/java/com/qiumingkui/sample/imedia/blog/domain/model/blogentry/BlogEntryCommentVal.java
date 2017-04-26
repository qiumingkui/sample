package com.qiumingkui.sample.imedia.blog.domain.model.blogentry;

public class BlogEntryCommentVal {
	private int commentNumber;

	private BlogEntryCommentVal() {
		super();
	}

	public BlogEntryCommentVal(int aCommentNumber) {
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
