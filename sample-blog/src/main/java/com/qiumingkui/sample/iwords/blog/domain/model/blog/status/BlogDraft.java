package com.qiumingkui.sample.iwords.blog.domain.model.blog.status;

import com.qiumingkui.sample.iwords.blog.domain.model.blog.Blog;

public class BlogDraft extends BlogStatus {

	
	public BlogDraft() {
		super();
		this.setCode(DRAFT);
	}

	
	public void draft(Blog blog) throws BlogStatusException {
		String message = "当前已经是拟稿状态，不能再修改为拟稿状态！";
		throw new BlogStatusException(message);
	}

	
	public void issue(Blog blog) {
		blog.changeStatus(new BlogIssued());
	}

	
	public void lock(Blog blog) throws BlogStatusException {
		String message = "当前是拟稿状态，不需锁定！";
		throw new BlogStatusException(message);
	}

	
	public void close(Blog blog) throws BlogStatusException {
		String message = "当前是拟稿状态，不需关闭！";
		throw new BlogStatusException(message);
	}

	
	public void reopen(Blog blog) throws BlogStatusException {
		String message = "当前已经是拟稿状态，不需重新打开！";
		throw new BlogStatusException(message);
	}


}
