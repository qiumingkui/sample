package com.qiumingkui.sample.imedia.blog.domain.model.comment;

public interface CommentRepository {

	public Comment get(CommentId aCommentId);

	public void save(Comment aComment);

	public void del(CommentId aCommentId);

}
