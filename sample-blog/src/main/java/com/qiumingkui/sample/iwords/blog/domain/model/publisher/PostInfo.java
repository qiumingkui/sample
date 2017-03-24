package com.qiumingkui.sample.iwords.blog.domain.model.publisher;

public class PostInfo {

	private int postNumber;
	
	private int commentNumber;
	
	private PostInfo() {
		super();
	}

	public PostInfo(int aPostNumber, int aCommentNumber) {
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
