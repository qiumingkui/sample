package com.qiumingkui.sample.imedia.mp.domain.model.comment;

import com.qiumingkui.sample.imedia.mp.domain.model.Content;
import com.qiumingkui.sample.imedia.mp.domain.model.post.PostId;
import com.qiumingkui.sample.iwords.common.util.UUIDUtils;

public class CommentBuilder {

	public static Comment build(String aId, String aBlogId, String aContent) {
		CommentId commentId = new CommentId(aId);
		PostId postId = new PostId(aBlogId);
		Content content = new Content(aContent);
		Comment comment = new Comment(commentId, postId, content);
		return comment;
	}

	public static Comment build(String aBlogId, String aContent) {
		final String COMMENT_ID = UUIDUtils.gen();
		return build(COMMENT_ID, aBlogId, aContent);
	}

}
