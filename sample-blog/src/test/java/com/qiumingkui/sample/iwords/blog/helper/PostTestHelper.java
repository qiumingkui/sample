package com.qiumingkui.sample.iwords.blog.helper;

import java.util.Date;

import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;
import com.qiumingkui.sample.iwords.blog.domain.model.post.Post;
import com.qiumingkui.sample.iwords.blog.domain.model.post.PostBuilder;

public class PostTestHelper {

	public static Post buildBlogExample() {
		// Person person = MemberTestHelper.buildPerson4CommonUserExample();
		Author author = MemberTestHelper.buildAuthorExample(true);
		return PostBuilder.build("blog" + " : " + new Date(), "content" + " : " + new Date(), author);
	}

}
