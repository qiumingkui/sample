package com.qiumingkui.sample.iwords.blog.helper;

import java.util.Date;

import com.qiumingkui.sample.iwords.blog.domain.model.comment.Comment;
import com.qiumingkui.sample.iwords.blog.domain.model.comment.CommentBuilder;

public class CommentTestHelper {
	public static Comment buildCommentExample() {
		return CommentBuilder.build("1", "content" + " : " + new Date());
	}

}
