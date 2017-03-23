package com.qiumingkui.sample.iwords.blog.helper;

import java.util.Date;

import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntry;
import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntryBuilder;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;

public class BlogEntryTestHelper {

	public static BlogEntry buildBlogExample() {
		// Person person = MemberTestHelper.buildPerson4CommonUserExample();
		Author author = MemberTestHelper.buildAuthorExample(true);
		return BlogEntryBuilder.build("blog" + " : " + new Date(), "content" + " : " + new Date(), author);
	}

}
