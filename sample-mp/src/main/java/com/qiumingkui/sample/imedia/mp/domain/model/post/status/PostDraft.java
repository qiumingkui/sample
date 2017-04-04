package com.qiumingkui.sample.imedia.mp.domain.model.post.status;

public class PostDraft extends PostStatus {

	public PostDraft() {
		super();
		this.setCode(DRAFT);
	}

	@Override
	public void draft() throws PostStatusException {
		String message = "当前已经是拟稿状态，不能再修改为拟稿状态！";
		throw new PostStatusException(message);
	}

	@Override
	public void issue() {
		// post.changeStatus(new PostIssued());
	}

	@Override
	public void lock() throws PostStatusException {
		String message = "当前是拟稿状态，不需锁定！";
		throw new PostStatusException(message);
	}

	@Override
	public void close() throws PostStatusException {
		String message = "当前是拟稿状态，不需关闭！";
		throw new PostStatusException(message);
	}

	@Override
	public void reopen() throws PostStatusException {
		String message = "当前已经是拟稿状态，不需重新打开！";
		throw new PostStatusException(message);
	}

}
