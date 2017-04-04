package com.qiumingkui.sample.imedia.mp.domain.model.post.status;

public class PostLocked extends PostStatus {

	public PostLocked() {
		super();
		setCode(LOCKED);
	}

	@Override
	public void draft() throws PostStatusException {
		String message = "当前已经锁定，不能再修改为拟稿状态！";
		throw new PostStatusException(message);
	}

	@Override
	public void issue() throws PostStatusException {
		String message = "当前已经锁定，不能发布！";
		throw new PostStatusException(message);
	}

	@Override
	public void lock() throws PostStatusException {
		String message = "当前已经锁定，不需再锁定！";
		throw new PostStatusException(message);
	}

	@Override
	public void close() throws PostStatusException {
		// post.changeStatus(new PostClosed());
	}

	@Override
	public void reopen() throws PostStatusException {
		// post.changeStatus(new PostIssued());
	}

}
