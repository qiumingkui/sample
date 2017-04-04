package com.qiumingkui.sample.imedia.mp.domain.model.post.status;

public abstract class PostStatus {

	public static final int DRAFT = 0;

	public static final int ISSUED = 1;

	public static final int LOCKED = 2;

	public static final int CLOSED = 3;

	private int code;
	
	public static PostStatus create(int code) {
		switch (code) {
		case PostStatus.DRAFT:
			return new PostDraft();
		case PostStatus.ISSUED:
			return new PostIssued();
		case PostStatus.LOCKED:
			return new PostLocked();
		case PostStatus.CLOSED:
			return new PostClosed();
		}
		return null;
	}

	public PostStatus() {
		super();
		this.setCode(DRAFT);
	}

	public int code() {
		return code;
	}

	protected void setCode(int code) {
		this.code = code;
	}

	public abstract void draft() throws PostStatusException;

	public abstract void issue() throws PostStatusException;

	public abstract void lock() throws PostStatusException;

	public abstract void close() throws PostStatusException;

	public abstract void reopen() throws PostStatusException;

}
