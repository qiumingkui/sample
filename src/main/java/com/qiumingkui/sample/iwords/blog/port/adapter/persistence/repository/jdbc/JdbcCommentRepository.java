package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiumingkui.sample.iwords.blog.domain.model.Comment;
import com.qiumingkui.sample.iwords.blog.domain.model.CommentId;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.dao.CommentDao;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.CommentRepository;

//@Service
public class JdbcCommentRepository implements CommentRepository {

	@Autowired
	private CommentDao commentDao;

	@Override
	public Comment get(CommentId aCommentId) {
		return commentDao.retrieve(aCommentId);
	}

	@Override
	public void save(Comment aComment) {
		Comment retrieveComment = commentDao.retrieve(aComment.commentId());
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
