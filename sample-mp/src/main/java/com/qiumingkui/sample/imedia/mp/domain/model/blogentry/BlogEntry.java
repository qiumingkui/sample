package com.qiumingkui.sample.imedia.mp.domain.model.blogentry;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.common.util.UtilDateTime;
import com.qiumingkui.sample.imedia.mp.domain.model.Content;
import com.qiumingkui.sample.imedia.mp.domain.model.Title;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.status.BlogEntryStatus;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.status.BlogEntryStatusException;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.status.Closed;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.status.Draft;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.status.Issued;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.status.Locked;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Author;

public class BlogEntry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected BlogEntry() {
		super();
	}

	private BlogEntryId blogEntryId;

	private Title title;

	private Content content;

	private BlogEntryStatus status;

	private Author author;

	private BlogEntryComment blogEntryComment;

	private Timestamp createTime;

	private Timestamp modifyTime;

	public BlogEntry(BlogEntryId aBlogId, Title aTitle, Content aContent, Author aAuthor) {
		this(aBlogId, aTitle, aContent, aAuthor, new Draft(), new BlogEntryComment(0), UtilDateTime.nowTimestamp(),
				UtilDateTime.nowTimestamp());
	}

	public BlogEntry(BlogEntryId aBlogId, Title aTitle, Content aContent, Author aAuthor, BlogEntryStatus aStatus,
			BlogEntryComment aPostComment, Timestamp aCreateTime, Timestamp aModifyTime) {
		this();
		this.setBlogId(aBlogId);
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
		setModifyTime(UtilDateTime.nowTimestamp());
	}

	public void changeContent(Content aContent) {
		setContent(aContent);
		setModifyTime(UtilDateTime.nowTimestamp());
	}

	public void changePostComment(BlogEntryComment aPostComment) {
		setPostComment(aPostComment);
	}

	public void issue() throws BlogEntryStatusException {
		this.status.issue();
		this.setStatus(new Issued());
	}

	public void reopen() throws BlogEntryStatusException {
		this.status.reopen();
		this.setStatus(new Issued());
	}

	public void lock() throws BlogEntryStatusException {
		this.status.lock();
		this.setStatus(new Locked());
	}

	public void close() throws BlogEntryStatusException {
		this.status.close();
		this.setStatus(new Closed());
	}

	public BlogEntryId blogEntryId() {
		return blogEntryId;
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

	public Author author() {
		return author;
	}

	public Timestamp createTime() {
		return createTime;
	}

	public Timestamp modifyTime() {
		return modifyTime;
	}

	private void setBlogId(BlogEntryId aBlogId) {
		this.blogEntryId = aBlogId;
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

	private void setAuthor(Author author) {
		this.author = author;
	}

	private void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	private void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

}
