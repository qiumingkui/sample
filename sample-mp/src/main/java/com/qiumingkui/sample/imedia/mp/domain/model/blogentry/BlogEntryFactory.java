package com.qiumingkui.sample.imedia.mp.domain.model.blogentry;

import com.qiumingkui.sample.imedia.common.util.UUIDUtils;
import com.qiumingkui.sample.imedia.mp.domain.model.Content;
import com.qiumingkui.sample.imedia.mp.domain.model.Title;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Author;

public class BlogEntryFactory {

	public static BlogEntry create(String aId, String aTitle, String aContent, Author aAuthor) {
		BlogEntryId blogEntryId = new BlogEntryId(aId);
		Title title = new Title(aTitle);
		Content content = new Content(aContent);
		BlogEntry blogEntry = new BlogEntry(blogEntryId, title, content, aAuthor);
		return blogEntry;
	}

	public static BlogEntry create(String aTitle, String aContent, Author aAuthor) {
		final String BLOG_ID = UUIDUtils.gen();
		return create(BLOG_ID, aTitle, aContent, aAuthor);
	}
	
}
