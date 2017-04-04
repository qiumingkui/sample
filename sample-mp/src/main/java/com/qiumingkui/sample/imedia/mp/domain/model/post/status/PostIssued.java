package com.qiumingkui.sample.imedia.mp.domain.model.post.status;

import com.qiumingkui.sample.imedia.mp.domain.model.post.Post;

public class PostIssued extends PostStatus {

	public PostIssued() {
		super();
		this.setCode(ISSUED);
	}

	@Override
	public void draft() throws PostStatusException {
		String message = "当前已经发布，不能再修改为拟稿状态！";
		throw new PostStatusException(message);

	}

	@Override
	public void issue() throws PostStatusException {
		String message = "当前已经发布！";
		throw new PostStatusException(message);
	}

	@Override
	public void lock() throws PostStatusException {
		// post.changeStatus(new PostLocked());
	}

	@Override
	public void close() throws PostStatusException {
		// post.changeStatus(new PostClosed());
	}

	@Override
	public void reopen() throws PostStatusException {
		String message = "当前已经发布，不需重新打开！";
		throw new PostStatusException(message);
	}

}
