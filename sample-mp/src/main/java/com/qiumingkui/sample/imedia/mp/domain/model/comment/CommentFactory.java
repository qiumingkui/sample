package com.qiumingkui.sample.imedia.mp.domain.model.comment;

import com.qiumingkui.sample.imedia.common.util.UUIDUtils;
import com.qiumingkui.sample.imedia.mp.domain.model.Content;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.BlogEntryId;

public class CommentFactory {

	public static Comment create(String aPostId, String aContent) {
		final String COMMENT_ID = UUIDUtils.gen();
		CommentId commentId = new CommentId(COMMENT_ID);
		BlogEntryId blogEntryId = new BlogEntryId(aPostId);
		Content content = new Content(aContent);
		Comment comment = new Comment().create(commentId, blogEntryId, content);
		return comment;
	}

}
