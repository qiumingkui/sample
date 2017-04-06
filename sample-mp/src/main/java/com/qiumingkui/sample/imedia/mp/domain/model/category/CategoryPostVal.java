package com.qiumingkui.sample.imedia.mp.domain.model.category;

public class CategoryPostVal {

	private long postNumber;

	private CategoryPostVal() {
		super();
	}

	public CategoryPostVal(long postNumber) {
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
