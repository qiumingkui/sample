package com.qiumingkui.sample.iwords.blog.domain.model.blogentry.status;

import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntry;

public class BlogEntryLocked extends BlogEntryStatus {

	
	public BlogEntryLocked() {
		super();
		setCode(LOCKED);
	}

	public void draft(BlogEntry blogEntry) throws BlogEntryStatusException {
		String message = "当前已经锁定，不能再修改为拟稿状态！";
		throw new BlogEntryStatusException(message);
	}

	
	public void issue(BlogEntry blogEntry) throws BlogEntryStatusException {
		String message = "当前已经锁定，不能发布！";
		throw new BlogEntryStatusException(message);
	}

	
	public void lock(BlogEntry blogEntry) throws BlogEntryStatusException {
		String message = "当前已经锁定，不需再锁定！";
		throw new BlogEntryStatusException(message);
	}

	
	public void close(BlogEntry blogEntry) throws BlogEntryStatusException {
		blogEntry.changeStatus(new BlogEntryClosed());
	}

	public void reopen(BlogEntry blogEntry) throws BlogEntryStatusException {
		blogEntry.changeStatus(new BlogEntryIssued());
	}

}
