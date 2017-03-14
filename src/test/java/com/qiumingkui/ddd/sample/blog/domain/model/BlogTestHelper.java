package com.qiumingkui.ddd.sample.blog.domain.model;

import java.util.Date;
import java.util.UUID;

public class BlogTestHelper {

	// public static final String TEST_ID =
	// UUID.randomUUID().toString().toUpperCase();
	// "E13DE0C4-B18A-42F6-B895-B88F0FBAFCBA";

	public static Blog buildBlog(String id, String titleTxt, String contentTxt) {
		BlogId blogId = new BlogId(id);
		Title title = new Title(titleTxt);
		Content content = new Content(contentTxt);
		Blog blog = new Blog(blogId, title, content);
		return blog;
	}

	public static Blog buildBlogExample() {
		final String BLOG_ID = UUID.randomUUID().toString().toUpperCase();
		return BlogTestHelper.buildBlog(BLOG_ID, "blog" + " : " + new Date(), "content" + " : " + new Date());
	}
}
