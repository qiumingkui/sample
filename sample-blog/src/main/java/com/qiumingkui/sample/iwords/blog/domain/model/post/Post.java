package com.qiumingkui.sample.iwords.blog.domain.model.post;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.iwords.blog.domain.model.Content;
import com.qiumingkui.sample.iwords.blog.domain.model.Title;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;
import com.qiumingkui.sample.iwords.blog.domain.model.post.status.PostDraft;
import com.qiumingkui.sample.iwords.blog.domain.model.post.status.PostStatus;
import com.qiumingkui.sample.iwords.blog.domain.model.post.status.PostStatusException;
import com.qiumingkui.sample.iwords.common.util.UtilDateTime;

public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Post() {
		super();
	}

	public Post(PostId aBlogId, Title aTitle, Content aContent, Author aAuthor) {
		this(aBlogId, aTitle, aContent, aAuthor, new PostDraft(), 0, UtilDateTime.nowTimestamp(),
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

	public Post(PostId aBlogId, Title aTitle, Content aContent, Author aAuthor, PostStatus aStatus, int aCommentNumber,
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

	private PostId postId;

	private Title title;

	private Content content;

	private PostStatus status;

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
	
	
	public void changeStatus(PostStatus aStatus){
		this.setStatus(aStatus);
	}
	
	public void issue() throws PostStatusException{
//		setStatus(new BlogStatus(BlogStatus.ISSUED));
		this.status.issue(this);
	}

	public void reopen() throws PostStatusException {
//		setStatus(new BlogStatus(BlogStatus.REOPEN));
		this.status.reopen(this);
	}

	public void lock() throws PostStatusException {
//		setStatus(new BlogStatus(BlogStatus.LOCKED));
		this.status.lock(this);
	}

	public void close() throws PostStatusException {
//		setStatus(new BlogStatus(BlogStatus.CLOSED));
		this.status.close(this);
	}

	public PostId postId() {
		return postId;
	}

	public Title title() {
		return title;
	}

	public Content content() {
		return content;
	}

	public PostStatus status() {
		return status;
	}

	public int commentNumber() {
		return commentNumber;
	}

	public Author author() {
		return author;
	}

	// public boolean isEditable() {
	// if (this.status().code() != BlogStatus.CLOSED && this.status().code() !=
	// BlogStatus.LOCKED)
	// return true;
	// return false;
	// }
	//
	// public boolean isReadable() {
	// if (this.status().code() != BlogStatus.CLOSED && this.status().code() !=
	// BlogStatus.LOCKED)
	// return true;
	// return false;
	// }

	private void setBlogId(PostId aBlogId) {
		this.postId = aBlogId;
	}

	private void setTitle(Title aTitle) {
		this.title = aTitle;
	}

	private void setContent(Content aContent) {
		this.content = aContent;
	}

	private void setStatus(PostStatus aStatus) {
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
