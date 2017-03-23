package com.qiumingkui.sample.iwords.blog.domain.model.comment;

import com.qiumingkui.sample.iwords.blog.domain.model.Content;
import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntryId;
import com.qiumingkui.sample.iwords.common.util.UUIDUtils;

public class CommentBuilder {

	public static Comment build(String aId, String aBlogId, String aContent) {
		CommentId commentId = new CommentId(aId);
		BlogEntryId blogEntryId = new BlogEntryId(aBlogId);
		Content content = new Content(aContent);
		Comment comment = new Comment(commentId, blogEntryId, content);
		return comment;
	}

	public static Comment build(String aBlogId, String aContent) {
		final String COMMENT_ID = UUIDUtils.gen();
		return build(COMMENT_ID, aBlogId, aContent);
	}

}
