package com.qiumingkui.sample.imedia.mp.domain.model.publisher.status;

import com.qiumingkui.sample.imedia.mp.domain.model.publisher.Blogger;

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

	public abstract void lock(Blogger publisher) throws BloggerStatusException;

	public abstract void close(Blogger publisher) throws BloggerStatusException;

	public abstract void reopen(Blogger publisher) throws BloggerStatusException;

	protected void setCode(int code) {
		this.code = code;
	}

}
