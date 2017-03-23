package com.qiumingkui.sample.iwords.blog.domain.model.blogentry;

import com.qiumingkui.sample.iwords.blog.domain.model.Content;
import com.qiumingkui.sample.iwords.blog.domain.model.Title;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;
import com.qiumingkui.sample.iwords.common.util.UUIDUtils;

public class BlogEntryBuilder {

	public static BlogEntry build(String aId, String aTitle, String aContent, Author aAuthor) {
		BlogEntryId blogEntryId = new BlogEntryId(aId);
		Title title = new Title(aTitle);
		Content content = new Content(aContent);
		BlogEntry blogEntry = new BlogEntry(blogEntryId, title, content, aAuthor);
		return blogEntry;
	}

	public static BlogEntry build(String aTitle, String aContent, Author aAuthor) {
		final String BLOG_ID = UUIDUtils.gen();
		return build(BLOG_ID, aTitle, aContent, aAuthor);
	}
	
}
