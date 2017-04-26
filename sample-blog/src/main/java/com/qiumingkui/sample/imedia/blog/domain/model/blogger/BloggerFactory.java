package com.qiumingkui.sample.imedia.blog.domain.model.blogger;

import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogOwner;
import com.qiumingkui.sample.imedia.common.ext.util.UUIDUtil;

public class BloggerFactory {

	public static Blogger build(BlogOwner aOwner) {
		final String BLOGGER_ID = UUIDUtil.gen();
		BloggerId id = new BloggerId(BLOGGER_ID);
		Blogger blogger = new Blogger(id, aOwner);
		return blogger;
	}

}
