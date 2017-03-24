package com.qiumingkui.sample.imedia.mp.port.adapter.persistence.repository;

import com.qiumingkui.sample.imedia.mp.domain.model.comment.Comment;
import com.qiumingkui.sample.imedia.mp.domain.model.comment.CommentId;

public interface CommentRepository {

	public Comment get(CommentId aCommentId);

	public void save(Comment aComment);

	public void del(CommentId aCommentId);

}
