package com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status;

public class Locked extends BlogEntryStatus {

	public Locked() {
		super();
		setCode(LOCKED);
	}

	@Override
	public void draft() throws BlogEntryStatusException {
		String message = "当前已经锁定，不能再修改为拟稿状态！";
		throw new BlogEntryStatusException(message);
	}

	@Override
	public void issue() throws BlogEntryStatusException {
		String message = "当前已经锁定，不能发布！";
		throw new BlogEntryStatusException(message);
	}

	@Override
	public void lock() throws BlogEntryStatusException {
		String message = "当前已经锁定，不需再锁定！";
		throw new BlogEntryStatusException(message);
	}

	@Override
	public void close() throws BlogEntryStatusException {
		// post.changeStatus(new PostClosed());
	}

	@Override
	public void reopen() throws BlogEntryStatusException {
		// post.changeStatus(new PostIssued());
	}

}
