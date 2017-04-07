package com.qiumingkui.sample.imedia.blog.port.adapter.persistence.repository.memory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.qiumingkui.sample.imedia.blog.domain.model.comment.Comment;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentId;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentRepository;

@Service
public class MemoryCommentRepository implements CommentRepository {

	private static Map<String, Comment> cache = new HashMap<String, Comment>();

	@Override
	public Comment get(CommentId aCommentId) {
		return cache.get(aCommentId.key());
	}

	@Override
	public void save(Comment aComment) {
		cache.put(aComment.id().key(), aComment);

	}

	@Override
	public void del(CommentId aCommentId) {
		cache.remove(aCommentId.key());
	}

}
