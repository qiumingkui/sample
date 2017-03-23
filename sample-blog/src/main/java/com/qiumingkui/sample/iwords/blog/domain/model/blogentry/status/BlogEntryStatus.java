package com.qiumingkui.sample.iwords.blog.domain.model.blogentry.status;

import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntry;

public abstract class BlogEntryStatus {

	public static final int DRAFT = 0;

	public static final int ISSUED = 1;

	public static final int LOCKED = 2;

	public static final int CLOSED = 3;

	private int code;
	
	public static BlogEntryStatus create(int code) {
		switch (code) {
		case BlogEntryStatus.DRAFT:
			return new BlogEntryDraft();
		case BlogEntryStatus.ISSUED:
			return new BlogEntryIssued();
		case BlogEntryStatus.LOCKED:
			return new BlogEntryLocked();
		case BlogEntryStatus.CLOSED:
			return new BlogEntryClosed();
		}
		return null;
	}

	public BlogEntryStatus() {
		super();
		this.setCode(DRAFT);
	}

	public int code() {
		return code;
	}

	protected void setCode(int code) {
		this.code = code;
	}

	public abstract void draft(BlogEntry blogEntry) throws BlogEntryStatusException;

	public abstract void issue(BlogEntry blogEntry) throws BlogEntryStatusException;

	public abstract void lock(BlogEntry blogEntry) throws BlogEntryStatusException;

	public abstract void close(BlogEntry blogEntry) throws BlogEntryStatusException;

	public abstract void reopen(BlogEntry blogEntry) throws BlogEntryStatusException;

}
