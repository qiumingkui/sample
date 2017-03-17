package com.qiumingkui.sample.iwords.blog.domain.model;

import com.qiumingkui.sample.iwords.common.util.UUIDUtils;

public class BlogBuilder {

	public static Blog build(String aId, String aTitle, String aContent) {
		BlogId blogId = new BlogId(aId);
		Title title = new Title(aTitle);
		Content content = new Content(aContent);
		Blog blog = new Blog(blogId, title, content);
		return blog;
	}
	
	public static Blog build(String aTitle, String aContent) {
		final String BLOG_ID = UUIDUtils.gen();
		return build(BLOG_ID,aTitle,aContent);
	}
}
