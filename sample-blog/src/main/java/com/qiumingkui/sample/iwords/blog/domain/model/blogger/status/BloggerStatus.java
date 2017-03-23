package com.qiumingkui.sample.iwords.blog.domain.model.blogger.status;

import com.qiumingkui.sample.iwords.blog.domain.model.blogger.Blogger;

public abstract class BloggerStatus {

	public static final int ONLINE = 0;

	public static final int LOCKED = 1;

	public static final int CLOSED = 2;

	private int code;
	
	public int code() {
		return code;
	}

	public static BloggerStatus create(int code) {
		
		return null;
	}
	
	public BloggerStatus() {
		super();
		this.setCode(ONLINE);
	}

	public abstract void lock(Blogger blogger) throws BloggerStatusException;

	public abstract void close(Blogger blogger) throws BloggerStatusException;

	public abstract void reopen(Blogger blogger) throws BloggerStatusException;

	protected void setCode(int code) {
		this.code = code;
	}

}
