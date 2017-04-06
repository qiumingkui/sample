package com.qiumingkui.sample.imedia.mp.domain.model.category;

public class CategoryPost {

	private long postNumber;

	private CategoryPost() {
		super();
	}

	public CategoryPost(long postNumber) {
		this();
		this.setPostNumber(postNumber);
	}

	public long postNumber() {
		return postNumber;
	}

	private void setPostNumber(long postNumber) {
		this.postNumber = postNumber;
	}

}
