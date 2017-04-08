package com.qiumingkui.sample.imedia.blog.domain.model.blogger.status;

public abstract class BloggerStatus {

	public static final int ONLINE = 0;

	public static final int LOCKED = 1;

	public static final int CLOSED = 2;

	private int code;
	
	public static BloggerStatus create(int code) {
		
		return null;
	}
	
	public BloggerStatus() {
		super();
		this.setCode(ONLINE);
	}

	public int code() {
		return code;
	}

	public abstract void lock() throws BloggerStatusException;

	public abstract void close() throws BloggerStatusException;

	public abstract void reopen() throws BloggerStatusException;

	protected void setCode(int code) {
		this.code = code;
	}

}
