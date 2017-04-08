package com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status;

public abstract class BlogEntryStatus {

	public static final int DRAFT = 0;

	public static final int ISSUED = 1;

	public static final int LOCKED = 2;

	public static final int CLOSED = 3;

	private int code;
	
	public static BlogEntryStatus create(int code) {
		switch (code) {
		case BlogEntryStatus.DRAFT:
			return new BlogEntryDraftStatus();
		case BlogEntryStatus.ISSUED:
			return new BlogEntryIssuedStatus();
		case BlogEntryStatus.LOCKED:
			return new BlogEntryLockedStatus();
		case BlogEntryStatus.CLOSED:
			return new BlogEntryClosedStatus();
		}
		return null;
	}

	public BlogEntryStatus() {
		super();
		this.setCode(DRAFT);
	}

	public int code() {
		return code;
	}

	protected void setCode(int code) {
		this.code = code;
	}

	public abstract void draft() throws BlogEntryStatusException;

	public abstract void issue() throws BlogEntryStatusException;

	public abstract void lock() throws BlogEntryStatusException;

	public abstract void close() throws BlogEntryStatusException;

	public abstract void reopen() throws BlogEntryStatusException;

}
