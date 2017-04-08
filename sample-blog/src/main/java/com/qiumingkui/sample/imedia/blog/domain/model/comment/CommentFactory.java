package com.qiumingkui.sample.imedia.blog.domain.model.comment;

import com.qiumingkui.sample.imedia.blog.domain.model.Content;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryId;
import com.qiumingkui.sample.imedia.common.util.UUIDUtil;

public class CommentFactory {

	public static Comment create(String aPostId, String aContent) {
		final String COMMENT_ID = UUIDUtil.gen();
		CommentId commentId = new CommentId(COMMENT_ID);
		BlogEntryId blogEntryId = new BlogEntryId(aPostId);
		Content content = new Content(aContent);
		Comment comment = new Comment();
		comment.create(commentId, blogEntryId, content);
		return comment;
	}

}
