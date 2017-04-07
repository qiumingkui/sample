package com.qiumingkui.sample.imedia.blog.helper;

import com.qiumingkui.sample.imedia.blog.domain.model.blogger.Blogger;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.BloggerFactory;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogOwner;

public class BloggerTestHelper {

	public static Blogger buildBloggerExample() {
		BlogOwner blogOwner = MemberTestHelper.buildOwner(true);
		Blogger blogger = BloggerFactory.build(blogOwner);
		return blogger;
	}
}
