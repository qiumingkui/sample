package com.qiumingkui.sample.imedia.mp.helper;

import com.qiumingkui.sample.imedia.mp.domain.model.member.Owner;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.Blogger;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.BloggerFactory;

public class BloggerTestHelper {

	public static Blogger buildBloggerExample() {
		Owner owner = MemberTestHelper.buildOwner(true);
		Blogger blogger = BloggerFactory.build(owner);
		return blogger;
	}
}
