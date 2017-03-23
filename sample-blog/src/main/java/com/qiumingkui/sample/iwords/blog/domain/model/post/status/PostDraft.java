package com.qiumingkui.sample.iwords.blog.domain.model.post.status;

import com.qiumingkui.sample.iwords.blog.domain.model.post.Post;

public class PostDraft extends PostStatus {

	
	public PostDraft() {
		super();
		this.setCode(DRAFT);
	}

	
	public void draft(Post post) throws PostStatusException {
		String message = "当前已经是拟稿状态，不能再修改为拟稿状态！";
		throw new PostStatusException(message);
	}

	
	public void issue(Post post) {
		post.changeStatus(new PostIssued());
	}

	
	public void lock(Post post) throws PostStatusException {
		String message = "当前是拟稿状态，不需锁定！";
		throw new PostStatusException(message);
	}

	
	public void close(Post post) throws PostStatusException {
		String message = "当前是拟稿状态，不需关闭！";
		throw new PostStatusException(message);
	}

	
	public void reopen(Post post) throws PostStatusException {
		String message = "当前已经是拟稿状态，不需重新打开！";
		throw new PostStatusException(message);
	}


}
