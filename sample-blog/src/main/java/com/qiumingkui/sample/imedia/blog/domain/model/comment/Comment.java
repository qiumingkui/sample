package com.qiumingkui.sample.imedia.blog.domain.model.comment;

import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.blog.domain.model.Content;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryId;
import com.qiumingkui.sample.imedia.common.domain.entity.IdentityEntity;
import com.qiumingkui.sample.imedia.common.util.DateTimeUtil;

public class Comment implements IdentityEntity<CommentId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CommentId id;

	private BlogEntryId blogEntryId;

	private Content content;

	private Timestamp createTime;

	protected Comment() {
		super();
	}

	protected void create(CommentId aId, BlogEntryId aBlogId, Content aContent) {
		this.init(aId, aBlogId, aContent, DateTimeUtil.nowTimestamp());
	}

	protected void init(CommentId aId, BlogEntryId aBlogId, Content aContent, Timestamp aCreateTime) {
		this.setCommentId(aId);
		this.setPostId(aBlogId);
		this.setContent(aContent);
		this.setCreateTime(aCreateTime);
	}

	public void changeContent(Content content) {
		this.setContent(content);

	}

	@Override
	public CommentId id() {
		return this.id;
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
		this.id = commentId;
	}

	private void setPostId(BlogEntryId blogEntryId) {
		this.blogEntryId = blogEntryId;
	}

	private void setContent(Content content) {
		this.content = content;
	}

	private void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
