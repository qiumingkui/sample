package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository;

import com.qiumingkui.ddd.sample.blog.domain.model.Comment;
import com.qiumingkui.ddd.sample.blog.domain.model.CommentId;

public interface CommentRepository {

	public Comment get(CommentId aCommentId);

	public void save(Comment aComment);
	
	public void del(CommentId aCommentId);

}
