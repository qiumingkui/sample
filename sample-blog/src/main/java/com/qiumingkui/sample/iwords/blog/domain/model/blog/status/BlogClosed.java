package com.qiumingkui.sample.iwords.blog.domain.model.blog.status;

import com.qiumingkui.sample.iwords.blog.domain.model.blog.Blog;

public class BlogClosed extends BlogStatus{
	
	public BlogClosed() {
		super();
		this.setCode(CLOSED);
	}

	@Override
	public void draft(Blog blog) throws BlogStatusException {
		String message = "当前已经关闭，不能再修改为拟稿状态！";
		throw new BlogStatusException(message);		
	}

	@Override
	public void issue(Blog blog) throws BlogStatusException {
		String message = "当前已经关闭，不能再发布！";
		throw new BlogStatusException(message);		
	}

	@Override
	public void lock(Blog blog) throws BlogStatusException {
		String message = "当前已经关闭，不需再锁定！";
		throw new BlogStatusException(message);		
	}

	@Override
	public void close(Blog blog) throws BlogStatusException {
		String message = "当前已经关闭，再次关闭！";
		throw new BlogStatusException(message);		

	}

	@Override
	public void reopen(Blog blog) throws BlogStatusException {
		blog.changeStatus(new BlogIssued());	
	}

}
