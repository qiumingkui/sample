package com.qiumingkui.sample.iwords.blog.domain.model.comment;

import com.qiumingkui.sample.iwords.blog.domain.model.Content;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.BlogId;
import com.qiumingkui.sample.iwords.common.util.UUIDUtils;

public class CommentBuilder {

	public static Comment build(String aId, String aBlogId, String aContent) {
		CommentId commentId = new CommentId(aId);
		BlogId blogId = new BlogId(aBlogId);
		Content content = new Content(aContent);
		Comment comment = new Comment(commentId, blogId, content);
		return comment;
	}

	public static Comment build(String aBlogId, String aContent) {
		final String COMMENT_ID = UUIDUtils.gen();
		return build(COMMENT_ID, aBlogId, aContent);
	}

}
