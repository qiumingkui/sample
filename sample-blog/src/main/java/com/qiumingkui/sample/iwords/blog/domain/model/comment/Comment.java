package com.qiumingkui.sample.iwords.blog.domain.model.comment;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.iwords.blog.domain.model.Content;
import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntryId;
import com.qiumingkui.sample.iwords.common.util.UtilDateTime;

public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CommentId commentId;

	private BlogEntryId blogEntryId;

	private Content content;

	private Timestamp createTime;

	private Comment() {
		super();
	}

	public Comment(CommentId aCommentId, BlogEntryId aBlogId, Content aContent) {
		this();

		this.setCommentId(aCommentId);
		this.setBlogId(aBlogId);
		this.setContent(aContent);
		this.setCreateTime(UtilDateTime.nowTimestamp());
	}

	public void changeContent(Content content) {
		this.setContent(content);

	}

	public CommentId commentId() {
		return this.commentId;
	}

	public BlogEntryId blogEntryId() {
		return this.blogEntryId;
	}

	public Content content() {
		return this.content;
	}

	public Timestamp createTime() {
		return createTime;
	}

	private void setCommentId(CommentId commentId) {
		this.commentId = commentId;
	}

	private void setBlogId(BlogEntryId blogEntryId) {
		this.blogEntryId = blogEntryId;
	}

	private void setContent(Content content) {
		this.content = content;
	}

	private void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
