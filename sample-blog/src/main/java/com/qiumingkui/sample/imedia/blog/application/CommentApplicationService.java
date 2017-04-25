package com.qiumingkui.sample.imedia.blog.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.imedia.blog.domain.model.comment.Comment;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentData;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentFactory;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentId;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentRepository;
import com.qiumingkui.sample.imedia.common.event.EventStore;
import com.qiumingkui.sample.imedia.common.event.MemoryEventStore;

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
		Comment comment = CommentFactory.create(aBlogId, aContent);
		commentRepository.save(comment);
		return comment.id().key();
	}

	public CommentData readComment(String aCommentId) {
		CommentId commentId = new CommentId(aCommentId);
		Comment comment = commentRepository.get(commentId);
		CommentData commentData = new CommentData(comment.id().key(), comment.id().key(),
				comment.content().contentTxt(), comment.createTime());
		return commentData;
	}

}
