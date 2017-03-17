package com.qiumingkui.sample.iwords.blog.helper;

import java.util.Date;

import com.qiumingkui.sample.iwords.blog.domain.model.Blog;
import com.qiumingkui.sample.iwords.blog.domain.model.BlogBuilder;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;
import com.qiumingkui.sample.iwords.blog.domain.model.member.MemberBuilder;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Person;

public class BlogTestHelper {

	public static Blog buildBlogExample() {
		Person person = MemberTestHelper.buildPerson4CommonUserExample();
		Author author = MemberBuilder.buildAuthor(person);
		return BlogBuilder.build("blog" + " : " + new Date(), "content" + " : " + new Date(), author);
	}

}
