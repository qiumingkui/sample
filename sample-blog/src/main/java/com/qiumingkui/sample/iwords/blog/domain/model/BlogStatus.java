package com.qiumingkui.sample.iwords.blog.domain.model;

public class BlogStatus {
	
	public static final int DRAFT =-1;

	public static final int ISSUE = 0;

	public static final int LOCK = 1;

	public static final int CLOSE = 2;

	public static final int REOPEN = 3;

	int statusVal = ISSUE;

	private BlogStatus() {
		super();
	}

	public BlogStatus(int aStatusVal) {
		this();
		this.statusVal = aStatusVal;
	}

	public int statusVal() {
		return this.statusVal;
	}

}
