package com.qiumingkui.sample.imedia.mp.domain.model.blogentry.status;

public class Draft extends BlogEntryStatus {

	public Draft() {
		super();
		this.setCode(DRAFT);
	}

	@Override
	public void draft() throws BlogEntryStatusException {
		String message = "当前已经是拟稿状态，不能再修改为拟稿状态！";
		throw new BlogEntryStatusException(message);
	}

	@Override
	public void issue() {
		// post.changeStatus(new PostIssued());
	}

	@Override
	public void lock() throws BlogEntryStatusException {
		String message = "当前是拟稿状态，不需锁定！";
		throw new BlogEntryStatusException(message);
	}

	@Override
	public void close() throws BlogEntryStatusException {
		String message = "当前是拟稿状态，不需关闭！";
		throw new BlogEntryStatusException(message);
	}

	@Override
	public void reopen() throws BlogEntryStatusException {
		String message = "当前已经是拟稿状态，不需重新打开！";
		throw new BlogEntryStatusException(message);
	}

}
