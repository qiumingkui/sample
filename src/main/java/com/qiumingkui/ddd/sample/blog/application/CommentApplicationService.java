package com.qiumingkui.ddd.sample.blog.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.ddd.sample.blog.domain.model.Comment;
import com.qiumingkui.ddd.sample.blog.domain.model.CommentBuilder;
import com.qiumingkui.ddd.sample.blog.domain.model.CommentData;
import com.qiumingkui.ddd.sample.blog.domain.model.CommentId;
import com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository.CommentRepository;

@Service
public class CommentApplicationService {

	@Autowired
	private CommentRepository commentRepository;

	/**
	 * 发表评论
	 * 
	 * @param aBlogId
	 * @param aContent
	 * @return
	 */
	@Transactional
	public String publishComment(String aBlogId, String aContent) {
		Comment comment = CommentBuilder.build(aBlogId, aContent);
		commentRepository.save(comment);
		return comment.commentId().id();
	}

	public CommentData readComment(String aCommentId) {
		CommentId commentId = new CommentId(aCommentId);
		Comment comment = commentRepository.get(commentId);
		CommentData commentData = new CommentData(comment.commentId().id(), comment.blogId().id(),
				comment.content().contentTxt(), comment.createTime());
		return commentData;
	}

}
