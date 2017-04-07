package com.qiumingkui.sample.imedia.mp.domain.model.comment;

import com.qiumingkui.sample.imedia.common.util.UUIDUtils;
import com.qiumingkui.sample.imedia.mp.domain.model.Content;
import com.qiumingkui.sample.imedia.mp.domain.model.post.PostId;

public class CommentFactory {

	public static Comment create(String aPostId, String aContent) {
		final String COMMENT_ID = UUIDUtils.gen();
		CommentId commentId = new CommentId(COMMENT_ID);
		PostId postId = new PostId(aPostId);
		Content content = new Content(aContent);
		Comment comment = new Comment().create(commentId, postId, content);
		return comment;
	}

}
