package com.qiumingkui.sample.imedia.mp.domain.model.post;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.common.util.UtilDateTime;
import com.qiumingkui.sample.imedia.mp.domain.model.Content;
import com.qiumingkui.sample.imedia.mp.domain.model.Title;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Author;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostClosed;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostDraft;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostIssued;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostLocked;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostStatus;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostStatusException;

public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Post() {
		super();
	}

	private PostId postId;

	private Title title;

	private Content content;

	private PostStatus status;

	private Author author;

	private PostComment postComment;

	private Timestamp createTime;

	private Timestamp modifyTime;

	public Post(PostId aBlogId, Title aTitle, Content aContent, Author aAuthor) {
		this(aBlogId, aTitle, aContent, aAuthor, new PostDraft(), new PostComment(0), UtilDateTime.nowTimestamp(),
				UtilDateTime.nowTimestamp());
	}

	public Post(PostId aBlogId, Title aTitle, Content aContent, Author aAuthor, PostStatus aStatus,
			PostComment aPostComment, Timestamp aCreateTime, Timestamp aModifyTime) {
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

	public void changePostComment(PostComment aPostComment) {
		setPostComment(aPostComment);
	}

	public void issue() throws PostStatusException {
		this.status.issue();
		this.setStatus(new PostIssued());
	}

	public void reopen() throws PostStatusException {
		this.status.reopen();
		this.setStatus(new PostIssued());
	}

	public void lock() throws PostStatusException {
		this.status.lock();
		this.setStatus(new PostLocked());
	}

	public void close() throws PostStatusException {
		this.status.close();
		this.setStatus(new PostClosed());
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

	public PostComment postComment() {
		return postComment;
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

	private void setPostComment(PostComment aPostCommentr) {
		this.postComment = aPostCommentr;
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
