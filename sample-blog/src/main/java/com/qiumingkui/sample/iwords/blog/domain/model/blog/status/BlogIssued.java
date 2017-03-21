package com.qiumingkui.sample.iwords.blog.domain.model.blog.status;

import com.qiumingkui.sample.iwords.blog.domain.model.blog.Blog;

public class BlogIssued extends BlogStatus {

	public BlogIssued() {
		super();
		this.setCode(ISSUED);
	}

	@Override
	public void draft(Blog blog) throws BlogStatusException {
		String message = "当前已经发布，不能再修改为拟稿状态！";
		throw new BlogStatusException(message);
		
	}

	@Override
	public void issue(Blog blog) throws BlogStatusException {
		String message = "当前已经发布！";
		throw new BlogStatusException(message);	
	}

	@Override
	public void lock(Blog blog) throws BlogStatusException {
		blog.changeStatus(new BlogLocked());
	}

	@Override
	public void close(Blog blog) throws BlogStatusException {
		blog.changeStatus(new BlogClosed());
	}

	@Override
	public void reopen(Blog blog) throws BlogStatusException {
		String message = "当前已经发布，不需重新打开！";
		throw new BlogStatusException(message);	
	}



}
