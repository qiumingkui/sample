package com.qiumingkui.sample.iwords.blog.domain.model.post;

import com.qiumingkui.sample.iwords.blog.domain.model.Content;
import com.qiumingkui.sample.iwords.blog.domain.model.Title;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;
import com.qiumingkui.sample.iwords.common.util.UUIDUtils;

public class PostBuilder {

	public static Post build(String aId, String aTitle, String aContent, Author aAuthor) {
		PostId postId = new PostId(aId);
		Title title = new Title(aTitle);
		Content content = new Content(aContent);
		Post post = new Post(postId, title, content, aAuthor);
		return post;
	}

	public static Post build(String aTitle, String aContent, Author aAuthor) {
		final String BLOG_ID = UUIDUtils.gen();
		return build(BLOG_ID, aTitle, aContent, aAuthor);
	}
	
}
