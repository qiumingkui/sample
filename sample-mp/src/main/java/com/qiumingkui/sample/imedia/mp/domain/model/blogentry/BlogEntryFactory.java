package com.qiumingkui.sample.imedia.mp.domain.model.blogentry;

import com.qiumingkui.sample.imedia.common.util.UUIDUtils;
import com.qiumingkui.sample.imedia.mp.domain.model.Content;
import com.qiumingkui.sample.imedia.mp.domain.model.Title;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Author;

public class BlogEntryFactory {

	public static BlogEntry create(String aTitle, String aContent, Author aAuthor) {

		final String BLOGENTRY_ID = UUIDUtils.gen();
		BlogEntryId blogEntryId = new BlogEntryId(BLOGENTRY_ID);
		Title title = new Title(aTitle);
		Content content = new Content(aContent);
		BlogEntry blogEntry = new BlogEntry().create(blogEntryId, title, content, aAuthor);
		return blogEntry;
	}

}
