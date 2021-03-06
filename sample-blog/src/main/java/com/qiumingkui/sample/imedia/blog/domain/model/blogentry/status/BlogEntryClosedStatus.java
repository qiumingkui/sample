package com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status;

public class BlogEntryClosedStatus extends BlogEntryStatus {

	public BlogEntryClosedStatus() {
		super();
		this.setCode(CLOSED);
	}

	@Override
	public void draft() throws BlogEntryStatusException {
		String message = "当前已经关闭，不能再修改为拟稿状态！";
		throw new BlogEntryStatusException(message);
	}

	@Override
	public void issue() throws BlogEntryStatusException {
		String message = "当前已经关闭，不能再发布！";
		throw new BlogEntryStatusException(message);
	}

	@Override
	public void lock() throws BlogEntryStatusException {
		String message = "当前已经关闭，不需再锁定！";
		throw new BlogEntryStatusException(message);
	}

	@Override
	public void close() throws BlogEntryStatusException {
		String message = "当前已经关闭，再次关闭！";
		throw new BlogEntryStatusException(message);

	}

	@Override
	public void reopen() throws BlogEntryStatusException {
		// post.changeStatus(new PostIssued());
	}

}
