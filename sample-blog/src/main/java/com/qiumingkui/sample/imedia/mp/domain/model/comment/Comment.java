package com.qiumingkui.sample.imedia.mp.domain.model.comment;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.mp.domain.model.Content;
import com.qiumingkui.sample.imedia.mp.domain.model.post.PostId;
import com.qiumingkui.sample.iwords.common.util.UtilDateTime;

public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CommentId commentId;

	private PostId postId;

	private Content content;

	private Timestamp createTime;

	private Comment() {
		super();
	}

	public Comment(CommentId aCommentId, PostId aBlogId, Content aContent) {
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
		this.commentId = commentId;
	}

	private void setBlogId(PostId postId) {
		this.postId = postId;
	}

	private void setContent(Content content) {
		this.content = content;
	}

	private void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
