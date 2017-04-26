package com.qiumingkui.sample.imedia.blog.domain.model.blogentry;

import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.blog.domain.model.Content;
import com.qiumingkui.sample.imedia.blog.domain.model.Title;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryStatusException;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryClosedStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryDraftStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryIssuedStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryLockedStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogAuthor;
import com.qiumingkui.sample.imedia.common.ext.entity.IdentityEntity;
import com.qiumingkui.sample.imedia.common.ext.util.DateTimeUtil;

public class BlogEntry implements IdentityEntity<BlogEntryId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BlogEntryId id;

	private Title title;

	private Content content;

	private BlogEntryStatus status;

	private BlogAuthor blogAuthor;

	private BlogEntryCommentVal commentVal;

	private Timestamp createTime;

	private Timestamp modifyTime;

	private BlogEntry() {
		super();
	}

	public BlogEntry(BlogEntryId aId, Title aTitle, Content aContent, BlogAuthor aAuthor) {
		this();
		this.init(aId, aTitle, aContent, aAuthor, new BlogEntryDraftStatus(), new BlogEntryCommentVal(0), DateTimeUtil.nowTimestamp(),
				DateTimeUtil.nowTimestamp());

	}

	public BlogEntry(BlogEntryId aId, Title aTitle, Content aContent, BlogAuthor aAuthor, BlogEntryStatus aStatus,
			BlogEntryCommentVal aBlogEntryCommentVal, Timestamp aCreateTime, Timestamp aModifyTime) {
		this();
		this.init(aId, aTitle, aContent, aAuthor, aStatus, aBlogEntryCommentVal, aCreateTime, aModifyTime);
	}
	
	
	private void init(BlogEntryId aId, Title aTitle, Content aContent, BlogAuthor aAuthor, BlogEntryStatus aStatus,
			BlogEntryCommentVal aBlogEntryCommentVal, Timestamp aCreateTime, Timestamp aModifyTime) {
		this.setId(aId);
		this.setTitle(aTitle);
		this.setContent(aContent);
		this.setAuthor(aAuthor);
		this.setStatus(aStatus);
		this.setCommentVal(aBlogEntryCommentVal);
		this.setCreateTime(aCreateTime);
		this.setModifyTime(aModifyTime);
	}

	public void changeTitle(Title aTitle) {
		setTitle(aTitle);
		setModifyTime(DateTimeUtil.nowTimestamp());
	}

	public void changeContent(Content aContent) {
		setContent(aContent);
		setModifyTime(DateTimeUtil.nowTimestamp());
	}

	public void changeCommentVal(BlogEntryCommentVal aBlogEntryCommentVal) {
		setCommentVal(aBlogEntryCommentVal);
	}

	public void issue() throws BlogEntryStatusException {
		this.status.issue();
		this.setStatus(new BlogEntryIssuedStatus());
	}

	public void reopen() throws BlogEntryStatusException {
		this.status.reopen();
		this.setStatus(new BlogEntryIssuedStatus());
	}

	public void lock() throws BlogEntryStatusException {
		this.status.lock();
		this.setStatus(new BlogEntryLockedStatus());
	}

	public void close() throws BlogEntryStatusException {
		this.status.close();
		this.setStatus(new BlogEntryClosedStatus());
	}

	@Override
	public BlogEntryId id() {
		return id;
	}

	public Title title() {
		return title;
	}

	public Content content() {
		return content;
	}

	public BlogEntryStatus status() {
		return status;
	}

	public BlogEntryCommentVal commentVal() {
		return commentVal;
	}

	public BlogAuthor blogAuthor() {
		return blogAuthor;
	}

	public Timestamp createTime() {
		return createTime;
	}

	public Timestamp modifyTime() {
		return modifyTime;
	}

	private void setId(BlogEntryId aBlogEntryId) {
		this.id = aBlogEntryId;
	}

	private void setTitle(Title aTitle) {
		this.title = aTitle;
	}

	private void setContent(Content aContent) {
		this.content = aContent;
	}

	private void setStatus(BlogEntryStatus aStatus) {
		this.status = aStatus;
	}

	private void setCommentVal(BlogEntryCommentVal aPostCommentr) {
		this.commentVal = aPostCommentr;
	}

	private void setAuthor(BlogAuthor blogAuthor) {
		this.blogAuthor = blogAuthor;
	}

	private void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	private void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

}
