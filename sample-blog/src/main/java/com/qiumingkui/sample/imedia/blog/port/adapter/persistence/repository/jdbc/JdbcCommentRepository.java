package com.qiumingkui.sample.imedia.blog.port.adapter.persistence.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiumingkui.sample.imedia.blog.domain.model.comment.Comment;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentId;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentRepository;
import com.qiumingkui.sample.imedia.blog.port.adapter.persistence.dao.CommentDao;


@Service
public class JdbcCommentRepository implements CommentRepository {

	@Autowired
	private CommentDao commentDao;

	@Override
	public Comment get(CommentId aCommentId) {
		return commentDao.retrieve(aCommentId);
	}

	@Override
	public void save(Comment aComment) {
		Comment retrieveComment = commentDao.retrieve(aComment.id());
		if (retrieveComment != null) {
			commentDao.update(aComment);
		} else {
			commentDao.create(aComment);
		}

	}

	@Override
	public void del(CommentId aCommentId) {
		commentDao.delete(aCommentId);
	}

}
