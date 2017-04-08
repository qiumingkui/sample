package com.qiumingkui.sample.imedia.blog.domain.model.blogger.status;

public class BloggerOnlineStatus extends BloggerStatus {

	public BloggerOnlineStatus() {
		super();
		this.setCode(ONLINE);
	}

	@Override
	public void lock() throws BloggerStatusException {
		// publisher.changeStatus(new BloggerLockedStatus());

	}

	@Override
	public void close() throws BloggerStatusException {
		// publisher.changeStatus(new BloggerClosedStatus());

	}

	@Override
	public void reopen() throws BloggerStatusException {
		String message = "当前已经在正常在线，不需重新打开！";
		throw new BloggerStatusException(message);
	}

}
