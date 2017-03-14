package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository;

import com.qiumingkui.ddd.sample.blog.domain.model.Comment;
import com.qiumingkui.ddd.sample.blog.domain.model.CommentId;

public interface CommentRepository {

	public Comment get(CommentId commentId);

	public CommentId genId();

	public void save(Comment comment);
	
	public void del(CommentId commentId);

}
