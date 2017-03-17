package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository;

import com.qiumingkui.sample.iwords.blog.domain.model.Comment;
import com.qiumingkui.sample.iwords.blog.domain.model.CommentId;

public interface CommentRepository {

	public Comment get(CommentId aCommentId);

	public void save(Comment aComment);
	
	public void del(CommentId aCommentId);

}
