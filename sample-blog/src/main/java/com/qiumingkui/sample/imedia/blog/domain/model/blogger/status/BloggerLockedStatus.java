package com.qiumingkui.sample.imedia.blog.domain.model.blogger.status;

public class BloggerLockedStatus extends BloggerStatus {

	public BloggerLockedStatus() {
		super();
		this.setCode(LOCKED);
	}

	@Override
	public void lock() throws BloggerStatusException {
		String message = "当前已经锁定，不需再锁定！";
		throw new BloggerStatusException(message);
	}

	@Override
	public void close() throws BloggerStatusException {
		String message = "当前已经关闭，不能再次锁定！";
		throw new BloggerStatusException(message);

	}

	@Override
	public void reopen() throws BloggerStatusException {
		// publisher.changeStatus(new BloggerOnlineStatus());

	}

}
