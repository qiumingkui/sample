package com.qiumingkui.sample.iwords.blog.domain.model.blogentry.status;

import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntry;

public class BlogEntryDraft extends BlogEntryStatus {

	
	public BlogEntryDraft() {
		super();
		this.setCode(DRAFT);
	}

	
	public void draft(BlogEntry blogEntry) throws BlogEntryStatusException {
		String message = "当前已经是拟稿状态，不能再修改为拟稿状态！";
		throw new BlogEntryStatusException(message);
	}

	
	public void issue(BlogEntry blogEntry) {
		blogEntry.changeStatus(new BlogEntryIssued());
	}

	
	public void lock(BlogEntry blogEntry) throws BlogEntryStatusException {
		String message = "当前是拟稿状态，不需锁定！";
		throw new BlogEntryStatusException(message);
	}

	
	public void close(BlogEntry blogEntry) throws BlogEntryStatusException {
		String message = "当前是拟稿状态，不需关闭！";
		throw new BlogEntryStatusException(message);
	}

	
	public void reopen(BlogEntry blogEntry) throws BlogEntryStatusException {
		String message = "当前已经是拟稿状态，不需重新打开！";
		throw new BlogEntryStatusException(message);
	}


}
