package com.qiumingkui.sample.imedia.mp.helper;

import java.util.Date;

import com.qiumingkui.sample.imedia.mp.domain.model.comment.Comment;
import com.qiumingkui.sample.imedia.mp.domain.model.comment.CommentFactory;

public class CommentTestHelper {
	public static Comment buildCommentExample() {
		return CommentFactory.create("1", "content" + " : " + new Date());
	}

}
