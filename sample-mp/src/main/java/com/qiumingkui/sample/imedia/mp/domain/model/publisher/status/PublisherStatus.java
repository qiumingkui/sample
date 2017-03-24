package com.qiumingkui.sample.imedia.mp.domain.model.publisher.status;

import com.qiumingkui.sample.imedia.mp.domain.model.publisher.Publisher;

public abstract class PublisherStatus {

	public static final int ONLINE = 0;

	public static final int LOCKED = 1;

	public static final int CLOSED = 2;

	private int code;
	
	public static PublisherStatus create(int code) {
		
		return null;
	}
	
	public PublisherStatus() {
		super();
		this.setCode(ONLINE);
	}

	public int code() {
		return code;
	}

	public abstract void lock(Publisher publisher) throws PublisherStatusException;

	public abstract void close(Publisher publisher) throws PublisherStatusException;

	public abstract void reopen(Publisher publisher) throws PublisherStatusException;

	protected void setCode(int code) {
		this.code = code;
	}

}
