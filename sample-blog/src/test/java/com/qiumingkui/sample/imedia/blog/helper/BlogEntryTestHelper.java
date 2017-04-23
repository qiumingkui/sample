package com.qiumingkui.sample.imedia.blog.helper;

import java.util.Date;

import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntry;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryFactory;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogAuthor;

public class BlogEntryTestHelper {

	public static BlogEntry buildBlogEntryExample() {
		// Person person = MemberTestHelper.buildPerson4CommonUserExample();
		BlogAuthor blogAuthor = MemberTestHelper.buildAuthorExample(true);
		return BlogEntryFactory.create("blog" + " : " + new Date(), "content" + " : " + new Date(), blogAuthor);
	}

}
