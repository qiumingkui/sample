package com.qiumingkui.sample.imedia.mp.helper;

import java.util.Date;

import com.qiumingkui.sample.imedia.mp.domain.model.member.Author;
import com.qiumingkui.sample.imedia.mp.domain.model.post.Post;
import com.qiumingkui.sample.imedia.mp.domain.model.post.PostBuilder;

public class PostTestHelper {

	public static Post buildBlogExample() {
		// Person person = MemberTestHelper.buildPerson4CommonUserExample();
		Author author = MemberTestHelper.buildAuthorExample(true);
		return PostBuilder.build("blog" + " : " + new Date(), "content" + " : " + new Date(), author);
	}

}
