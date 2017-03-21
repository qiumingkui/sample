package com.qiumingkui.sample.iwords.blog.domain.model.blog;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.iwords.blog.domain.model.Content;
import com.qiumingkui.sample.iwords.blog.domain.model.Title;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.status.BlogDraft;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.status.BlogStatus;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.status.BlogStatusException;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;
import com.qiumingkui.sample.iwords.common.util.UtilDateTime;

public class Blog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Blog() {
		super();
	}

	public Blog(BlogId aBlogId, Title aTitle, Content aContent, Author aAuthor) {
		this(aBlogId, aTitle, aContent, aAuthor, new BlogDraft(), 0, UtilDateTime.nowTimestamp(),
				UtilDateTime.nowTimestamp());
		// this();
		// this.setBlogId(aBlogId);
		// this.setTitle(aTitle);
		// this.setContent(aContent);
		// this.setStatus(new BlogStatus(BlogStatus.DRAFT));
		// this.setAuthor(aAuthor);
		// this.setCreateTime(UtilDateTime.nowTimestamp());
		// this.setModifyTime(UtilDateTime.nowTimestamp());
	}

	public Blog(BlogId aBlogId, Title aTitle, Content aContent, Author aAuthor, BlogStatus aStatus, int aCommentNumber,
			Timestamp aCreateTime, Timestamp aModifyTime) {

		// this(aBlogId, aTitle, aContent, aAuthor);
		//
		// this.setStatus(aStatus);
		// this.setCommentNumber(aCommentNumber);
		// this.setCreateTime(aCreateTime);
		// this.setModifyTime(aModifyTime);

		this();
		this.setBlogId(aBlogId);
		this.setTitle(aTitle);
		this.setContent(aContent);
		this.setAuthor(aAuthor);
		this.setStatus(aStatus);
		this.setCommentNumber(aCommentNumber);
		this.setCreateTime(aCreateTime);
		this.setModifyTime(aModifyTime);

	}

	private BlogId blogId;

	private Title title;

	private Content content;

	private BlogStatus status;

	private Author author;

	private int commentNumber;

	private Timestamp createTime;

	private Timestamp modifyTime;

	public Timestamp createTime() {
		return createTime;
	}

	public Timestamp modifyTime() {
		return modifyTime;
	}

	public void changeTitle(Title aTitle) {
		setTitle(aTitle);
		setModifyTime(UtilDateTime.nowTimestamp());
	}

	public void changeContent(Content aContent) {
		setContent(aContent);
		setModifyTime(UtilDateTime.nowTimestamp());
	}

	public void changeCommentNumber(int aCommentNumber) {
		setCommentNumber(aCommentNumber);
	}
	
	
	public void changeStatus(BlogStatus aStatus){
		this.setStatus(aStatus);
	}
	
	public void issue() throws BlogStatusException{
//		setStatus(new BlogStatus(BlogStatus.ISSUED));
		this.status.issue(this);
	}

	public void reopen() throws BlogStatusException {
//		setStatus(new BlogStatus(BlogStatus.REOPEN));
		this.status.reopen(this);
	}

	public void lock() throws BlogStatusException {
//		setStatus(new BlogStatus(BlogStatus.LOCKED));
		this.status.lock(this);
	}

	public void close() throws BlogStatusException {
//		setStatus(new BlogStatus(BlogStatus.CLOSED));
		this.status.close(this);
	}

	public BlogId blogId() {
		return blogId;
	}

	public Title title() {
		return title;
	}

	public Content content() {
		return content;
	}

	public BlogStatus status() {
		return status;
	}

	public int commentNumber() {
		return commentNumber;
	}

	public Author author() {
		return author;
	}

	public boolean isEditable() {
		if (this.status().code() != BlogStatus.CLOSED && this.status().code() != BlogStatus.LOCKED)
			return true;
		return false;
	}

	public boolean isReadable() {
		if (this.status().code() != BlogStatus.CLOSED && this.status().code() != BlogStatus.LOCKED)
			return true;
		return false;
	}

	private void setBlogId(BlogId aBlogId) {
		this.blogId = aBlogId;
	}

	private void setTitle(Title aTitle) {
		this.title = aTitle;
	}

	private void setContent(Content aContent) {
		this.content = aContent;
	}

	private void setStatus(BlogStatus aStatus) {
		this.status = aStatus;
	}

	private void setCommentNumber(int aCommentNumber) {
		this.commentNumber = aCommentNumber;
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
