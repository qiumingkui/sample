package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiumingkui.ddd.sample.blog.domain.model.Comment;
import com.qiumingkui.ddd.sample.blog.domain.model.CommentId;
import com.qiumingkui.ddd.sample.blog.port.adapter.persistence.dao.CommentDao;

@Service
public class JdbcCommentRepository implements CommentRepository {

	@Autowired
	private CommentDao commentDao;

	@Override
	public Comment get(CommentId commentId) {
		return commentDao.retrieve(commentId);
	}

	@Override
	public CommentId genId() {
		return new CommentId(UUID.randomUUID().toString().toUpperCase());
	}

	@Override
	public void save(Comment comment) {
		Comment retrieveComment = commentDao.retrieve(comment.commentId());
		if (retrieveComment != null) {
			commentDao.update(comment);
		} else {
			commentDao.create(comment);
		}

	}

	@Override
	public void del(CommentId commentId) {
		commentDao.delete(commentId);
	}

}
