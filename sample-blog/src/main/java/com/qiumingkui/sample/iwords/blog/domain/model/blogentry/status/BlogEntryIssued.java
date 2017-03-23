package com.qiumingkui.sample.iwords.blog.domain.model.blogentry.status;

import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntry;

public class BlogEntryIssued extends BlogEntryStatus {

	public BlogEntryIssued() {
		super();
		this.setCode(ISSUED);
	}

	@Override
	public void draft(BlogEntry blogEntry) throws BlogEntryStatusException {
		String message = "当前已经发布，不能再修改为拟稿状态！";
		throw new BlogEntryStatusException(message);
		
	}

	@Override
	public void issue(BlogEntry blogEntry) throws BlogEntryStatusException {
		String message = "当前已经发布！";
		throw new BlogEntryStatusException(message);	
	}

	@Override
	public void lock(BlogEntry blogEntry) throws BlogEntryStatusException {
		blogEntry.changeStatus(new BlogEntryLocked());
	}

	@Override
	public void close(BlogEntry blogEntry) throws BlogEntryStatusException {
		blogEntry.changeStatus(new BlogEntryClosed());
	}

	@Override
	public void reopen(BlogEntry blogEntry) throws BlogEntryStatusException {
		String message = "当前已经发布，不需重新打开！";
		throw new BlogEntryStatusException(message);	
	}



}
