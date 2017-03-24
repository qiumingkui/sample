package com.qiumingkui.sample.imedia.mp.domain.model.publisher;

public class PublisherPost {

	private int postNumber;
	
	private int commentNumber;
	
	private PublisherPost() {
		super();
	}

	public PublisherPost(int aPostNumber, int aCommentNumber) {
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
