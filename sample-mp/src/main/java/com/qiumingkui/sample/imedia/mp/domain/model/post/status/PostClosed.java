package com.qiumingkui.sample.imedia.mp.domain.model.post.status;

import com.qiumingkui.sample.imedia.mp.domain.model.post.Post;

public class PostClosed extends PostStatus {

	public PostClosed() {
		super();
		this.setCode(CLOSED);
	}

	@Override
	public void draft() throws PostStatusException {
		String message = "当前已经关闭，不能再修改为拟稿状态！";
		throw new PostStatusException(message);
	}

	@Override
	public void issue() throws PostStatusException {
		String message = "当前已经关闭，不能再发布！";
		throw new PostStatusException(message);
	}

	@Override
	public void lock() throws PostStatusException {
		String message = "当前已经关闭，不需再锁定！";
		throw new PostStatusException(message);
	}

	@Override
	public void close() throws PostStatusException {
		String message = "当前已经关闭，再次关闭！";
		throw new PostStatusException(message);

	}

	@Override
	public void reopen() throws PostStatusException {
		// post.changeStatus(new PostIssued());
	}

}
