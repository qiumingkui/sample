package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository;

import com.qiumingkui.sample.iwords.blog.domain.model.comment.Comment;
import com.qiumingkui.sample.iwords.blog.domain.model.comment.CommentId;

public interface CommentRepository {

	public Comment get(CommentId aCommentId);

	public void save(Comment aComment);

	public void del(CommentId aCommentId);

}
