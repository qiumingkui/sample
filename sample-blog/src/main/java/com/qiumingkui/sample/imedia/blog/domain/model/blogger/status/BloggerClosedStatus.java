package com.qiumingkui.sample.imedia.blog.domain.model.blogger.status;

public class BloggerClosedStatus extends BloggerStatus {

	public BloggerClosedStatus() {
		super();
		this.setCode(CLOSED);
	}

	@Override
	public void lock() throws BloggerStatusException {
		String message = "当前已经关闭，不需再锁定！";
		throw new BloggerStatusException(message);
	}

	@Override
	public void close() throws BloggerStatusException {
		String message = "当前已经关闭，不需再次关闭！";
		throw new BloggerStatusException(message);

	}

	@Override
	public void reopen() throws BloggerStatusException {
		// publisher.changeStatus(new BloggerOnlineStatus());

	}

}
