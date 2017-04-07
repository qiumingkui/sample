package com.qiumingkui.sample.imedia.mp.helper;

import com.qiumingkui.sample.imedia.mp.domain.model.blogger.Blogger;
import com.qiumingkui.sample.imedia.mp.domain.model.blogger.BloggerFactory;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Owner;

public class BloggerTestHelper {

	public static Blogger buildBloggerExample() {
		Owner owner = MemberTestHelper.buildOwner(true);
		Blogger blogger = BloggerFactory.build(owner);
		return blogger;
	}
}
