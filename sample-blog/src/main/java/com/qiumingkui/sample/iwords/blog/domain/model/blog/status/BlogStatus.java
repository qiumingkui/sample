package com.qiumingkui.sample.iwords.blog.domain.model.blog.status;

import com.qiumingkui.sample.iwords.blog.domain.model.blog.Blog;

public abstract class BlogStatus {

	public static final int DRAFT = 0;

	public static final int ISSUED = 1;

	public static final int LOCKED = 2;

	public static final int CLOSED = 3;

	private int code;
	
	public static BlogStatus create(int code) {
		switch (code) {
		case BlogStatus.DRAFT:
			return new BlogDraft();
		case BlogStatus.ISSUED:
			return new BlogIssued();
		case BlogStatus.LOCKED:
			return new BlogLocked();
		case BlogStatus.CLOSED:
			return new BlogClosed();
		}
		return null;
	}

	public BlogStatus() {
		super();
		this.setCode(DRAFT);
	}

	public int code() {
		return code;
	}

	protected void setCode(int code) {
		this.code = code;
	}

	public abstract void draft(Blog blog) throws BlogStatusException;

	public abstract void issue(Blog blog) throws BlogStatusException;

	public abstract void lock(Blog blog) throws BlogStatusException;

	public abstract void close(Blog blog) throws BlogStatusException;

	public abstract void reopen(Blog blog) throws BlogStatusException;

}
