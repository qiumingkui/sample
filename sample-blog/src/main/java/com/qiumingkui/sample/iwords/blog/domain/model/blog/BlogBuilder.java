package com.qiumingkui.sample.iwords.blog.domain.model.blog;

import com.qiumingkui.sample.iwords.blog.domain.model.Content;
import com.qiumingkui.sample.iwords.blog.domain.model.Title;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.status.BlogClosed;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.status.BlogDraft;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.status.BlogIssued;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.status.BlogLocked;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.status.BlogStatus;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;
import com.qiumingkui.sample.iwords.common.util.UUIDUtils;

public class BlogBuilder {

	public static Blog build(String aId, String aTitle, String aContent, Author aAuthor) {
		BlogId blogId = new BlogId(aId);
		Title title = new Title(aTitle);
		Content content = new Content(aContent);
		Blog blog = new Blog(blogId, title, content, aAuthor);
		return blog;
	}

	public static Blog build(String aTitle, String aContent, Author aAuthor) {
		final String BLOG_ID = UUIDUtils.gen();
		return build(BLOG_ID, aTitle, aContent, aAuthor);
	}

}
