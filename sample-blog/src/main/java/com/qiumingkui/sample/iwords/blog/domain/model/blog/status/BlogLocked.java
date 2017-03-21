package com.qiumingkui.sample.iwords.blog.domain.model.blog.status;

import com.qiumingkui.sample.iwords.blog.domain.model.blog.Blog;

public class BlogLocked extends BlogStatus {

	
	public BlogLocked() {
		super();
		setCode(LOCKED);
	}

	public void draft(Blog blog) throws BlogStatusException {
		String message = "当前已经锁定，不能再修改为拟稿状态！";
		throw new BlogStatusException(message);
	}

	
	public void issue(Blog blog) throws BlogStatusException {
		String message = "当前已经锁定，不能发布！";
		throw new BlogStatusException(message);
	}

	
	public void lock(Blog blog) throws BlogStatusException {
		String message = "当前已经锁定，不需再锁定！";
		throw new BlogStatusException(message);
	}

	
	public void close(Blog blog) throws BlogStatusException {
		blog.changeStatus(new BlogClosed());
	}

	public void reopen(Blog blog) throws BlogStatusException {
		blog.changeStatus(new BlogIssued());
	}

}
