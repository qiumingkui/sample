package com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status;

public class BlogEntryIssuedStatus extends BlogEntryStatus {

	public BlogEntryIssuedStatus() {
		super();
		this.setCode(ISSUED);
	}

	@Override
	public void draft() throws BlogEntryStatusException {
		String message = "当前已经发布，不能再修改为拟稿状态！";
		throw new BlogEntryStatusException(message);

	}

	@Override
	public void issue() throws BlogEntryStatusException {
		String message = "当前已经发布！";
		throw new BlogEntryStatusException(message);
	}

	@Override
	public void lock() throws BlogEntryStatusException {
		// post.changeStatus(new PostLocked());
	}

	@Override
	public void close() throws BlogEntryStatusException {
		// post.changeStatus(new PostClosed());
	}

	@Override
	public void reopen() throws BlogEntryStatusException {
		String message = "当前已经发布，不需重新打开！";
		throw new BlogEntryStatusException(message);
	}

}
