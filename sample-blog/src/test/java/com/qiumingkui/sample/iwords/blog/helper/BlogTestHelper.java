package com.qiumingkui.sample.iwords.blog.helper;

import java.util.Date;

import com.qiumingkui.sample.iwords.blog.domain.model.blog.Blog;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.BlogBuilder;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;

public class BlogTestHelper {

	public static Blog buildBlogExample() {
		// Person person = MemberTestHelper.buildPerson4CommonUserExample();
		Author author = MemberTestHelper.buildAuthorExample(true);
		return BlogBuilder.build("blog" + " : " + new Date(), "content" + " : " + new Date(), author);
	}

}
