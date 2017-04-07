package com.qiumingkui.sample.imedia.mp.domain.model.comment;

import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.common.domain.entity.IdentityEntity;
import com.qiumingkui.sample.imedia.common.util.UtilDateTime;
import com.qiumingkui.sample.imedia.mp.domain.model.Content;
import com.qiumingkui.sample.imedia.mp.domain.model.post.PostId;

public class Comment implements IdentityEntity<CommentId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CommentId id;

	private PostId postId;

	private Content content;

	private Timestamp createTime;

	protected Comment() {
		super();
	}

	protected Comment create(CommentId aId, PostId aBlogId, Content aContent) {
		this.init(aId, aBlogId, aContent, UtilDateTime.nowTimestamp());
		return this;
	}

	protected void init(CommentId aId, PostId aBlogId, Content aContent, Timestamp aCreateTime) {
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

	public PostId postId() {
		return this.postId;
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

	private void setPostId(PostId postId) {
		this.postId = postId;
	}

	private void setContent(Content content) {
		this.content = content;
	}

	private void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
