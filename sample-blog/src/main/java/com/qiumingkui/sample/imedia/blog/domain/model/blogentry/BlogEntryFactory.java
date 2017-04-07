package com.qiumingkui.sample.imedia.blog.domain.model.blogentry;

import com.qiumingkui.sample.imedia.blog.domain.model.Content;
import com.qiumingkui.sample.imedia.blog.domain.model.Title;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogAuthor;
import com.qiumingkui.sample.imedia.common.util.UUIDUtil;

public class BlogEntryFactory {

	public static BlogEntry create(String aTitle, String aContent, BlogAuthor aAuthor) {

		final String BLOGENTRY_ID = UUIDUtil.gen();
		BlogEntryId blogEntryId = new BlogEntryId(BLOGENTRY_ID);
		Title title = new Title(aTitle);
		Content content = new Content(aContent);
		BlogEntry blogEntry = new BlogEntry().create(blogEntryId, title, content, aAuthor);
		return blogEntry;
	}

}
