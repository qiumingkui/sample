package com.qiumingkui.sample.imedia.mp.domain.model.post;

public class PostComment {
	private int commentNumber;

	private PostComment() {
		super();
	}

	public PostComment(int aCommentNumber) {
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
