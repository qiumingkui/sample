package com.qiumingkui.sample.imedia.blog.domain.model.category;

public class CategoryVal {

	private long postNumber;

	private CategoryVal() {
		super();
	}

	public CategoryVal(long postNumber) {
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
