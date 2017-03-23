package com.qiumingkui.sample.iwords.blog.domain.model.blogentry.status;

import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntry;

public class BlogEntryClosed extends BlogEntryStatus{
	
	public BlogEntryClosed() {
		super();
		this.setCode(CLOSED);
	}

	@Override
	public void draft(BlogEntry blogEntry) throws BlogEntryStatusException {
		String message = "当前已经关闭，不能再修改为拟稿状态！";
		throw new BlogEntryStatusException(message);		
	}

	@Override
	public void issue(BlogEntry blogEntry) throws BlogEntryStatusException {
		String message = "当前已经关闭，不能再发布！";
		throw new BlogEntryStatusException(message);		
	}

	@Override
	public void lock(BlogEntry blogEntry) throws BlogEntryStatusException {
		String message = "当前已经关闭，不需再锁定！";
		throw new BlogEntryStatusException(message);		
	}

	@Override
	public void close(BlogEntry blogEntry) throws BlogEntryStatusException {
		String message = "当前已经关闭，再次关闭！";
		throw new BlogEntryStatusException(message);		

	}

	@Override
	public void reopen(BlogEntry blogEntry) throws BlogEntryStatusException {
		blogEntry.changeStatus(new BlogEntryIssued());	
	}

}
