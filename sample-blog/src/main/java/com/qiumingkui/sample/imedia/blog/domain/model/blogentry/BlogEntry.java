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

	private BlogEntryComment blogEntryComment;

	private Timestamp createTime;

	private Timestamp modifyTime;

	public BlogEntry() {
		super();
	}

	protected void create(BlogEntryId aId, Title aTitle, Content aContent, BlogAuthor aAuthor) {
		this.init(aId, aTitle, aContent, aAuthor, new BlogEntryDraftStatus(), new BlogEntryComment(0), DateTimeUtil.nowTimestamp(),
				DateTimeUtil.nowTimestamp());

	}

	public void init(BlogEntryId aId, Title aTitle, Content aContent, BlogAuthor aAuthor, BlogEntryStatus aStatus,
			BlogEntryComment aPostComment, Timestamp aCreateTime, Timestamp aModifyTime) {
		this.setId(aId);
		this.setTitle(aTitle);
		this.setContent(aContent);
		this.setAuthor(aAuthor);
		this.setStatus(aStatus);
		this.setPostComment(aPostComment);
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

	public void changePostComment(BlogEntryComment aPostComment) {
		setPostComment(aPostComment);
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

	public BlogEntryComment blogEntryComment() {
		return blogEntryComment;
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

	private void setPostComment(BlogEntryComment aPostCommentr) {
		this.blogEntryComment = aPostCommentr;
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
