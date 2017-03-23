package com.qiumingkui.sample.iwords.blog.domain.model.post.status;

import com.qiumingkui.sample.iwords.blog.domain.model.post.Post;

public class PostLocked extends PostStatus {

	
	public PostLocked() {
		super();
		setCode(LOCKED);
	}

	public void draft(Post post) throws PostStatusException {
		String message = "当前已经锁定，不能再修改为拟稿状态！";
		throw new PostStatusException(message);
	}

	
	public void issue(Post post) throws PostStatusException {
		String message = "当前已经锁定，不能发布！";
		throw new PostStatusException(message);
	}

	
	public void lock(Post post) throws PostStatusException {
		String message = "当前已经锁定，不需再锁定！";
		throw new PostStatusException(message);
	}

	
	public void close(Post post) throws PostStatusException {
		post.changeStatus(new PostClosed());
	}

	public void reopen(Post post) throws PostStatusException {
		post.changeStatus(new PostIssued());
	}

}
