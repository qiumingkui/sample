package com.qiumingkui.ddd.sample.blog.domain.model;

import java.util.Date;
import java.util.UUID;

public class CommentTestHelper {

	// public static final String TEST_ID =
	// UUID.randomUUID().toString().toUpperCase();
	// "DAA8AFD6-4537-4687-9D15-D7A4B7EE4505";

	public static Comment buildComment(String id, String blogid, String contentTxt) {
		CommentId commentId = new CommentId(id);
		BlogId blogId = new BlogId(blogid);
		Content content = new Content(contentTxt);
		Comment comment = new Comment(commentId, blogId, content);
		return comment;
	}

	public static Comment buildCommentExample() {
		final String COMMENT_ID = UUID.randomUUID().toString().toUpperCase();
		final String BLOG_ID = UUID.randomUUID().toString().toUpperCase();
		return CommentTestHelper.buildComment(COMMENT_ID, BLOG_ID, " ,content" + " : " + new Date());
	}

}
