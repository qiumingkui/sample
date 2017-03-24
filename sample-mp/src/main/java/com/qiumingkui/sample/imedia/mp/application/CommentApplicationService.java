package com.qiumingkui.sample.imedia.mp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.imedia.mp.domain.model.comment.Comment;
import com.qiumingkui.sample.imedia.mp.domain.model.comment.CommentBuilder;
import com.qiumingkui.sample.imedia.mp.domain.model.comment.CommentData;
import com.qiumingkui.sample.imedia.mp.domain.model.comment.CommentId;
import com.qiumingkui.sample.imedia.mp.port.adapter.persistence.repository.CommentRepository;

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
	// @Transactional
	public String publishComment(String aBlogId, String aContent) {
		Comment comment = CommentBuilder.build(aBlogId, aContent);
		commentRepository.save(comment);
		return comment.commentId().id();
	}

	public CommentData readComment(String aCommentId) {
		CommentId commentId = new CommentId(aCommentId);
		Comment comment = commentRepository.get(commentId);
		CommentData commentData = new CommentData(comment.commentId().id(), comment.commentId().id(),
				comment.content().contentTxt(), comment.createTime());
		return commentData;
	}

}
