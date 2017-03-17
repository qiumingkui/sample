package com.qiumingkui.sample.iwords.blog.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.iwords.common.util.UtilDateTime;

public class Blog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Blog() {
		super();
	}

	public Blog(BlogId aBlogId, Title aTitle, Content aContent) {
		this();
		this.setBlogId(aBlogId);
		this.setTitle(aTitle);
		this.setContent(aContent);
		this.setStatus(new BlogStatus(BlogStatus.ISSUE));
		this.setCreateTime(UtilDateTime.nowTimestamp());
		this.setModifyTime(UtilDateTime.nowTimestamp());
	}

	public Blog(BlogId aBlogId, Title aTitle, Content aContent, BlogStatus aStatus, int aCommentNumber, Timestamp aCreateTime,
			Timestamp aModifyTime) {
		
		this(aBlogId,aTitle,aContent);
		
		this.setStatus(aStatus);
		this.setCommentNumber(aCommentNumber);
		this.setCreateTime(aCreateTime);
		this.setModifyTime(aModifyTime);
	}

	private BlogId blogId;

	private Title title;

	private Content content;

	private BlogStatus status;

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

	public void reopen() {
		setStatus(new BlogStatus(BlogStatus.REOPEN));
	}

	public void lock() {
		setStatus(new BlogStatus(BlogStatus.LOCK));
	}

	public void close() {
		setStatus(new BlogStatus(BlogStatus.CLOSE));
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

	public boolean isEditable(){
		if (this.status().statusVal() != BlogStatus.CLOSE && this.status().statusVal() != BlogStatus.LOCK)
			return true;
		return false;
	}

	public boolean isReadable(){
		if (this.status().statusVal() != BlogStatus.CLOSE && this.status().statusVal() != BlogStatus.LOCK)
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

	private void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	private void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

}
