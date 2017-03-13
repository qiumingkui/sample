package com.qiumingkui.ddd.sample.blog.domain.model;

import java.util.Date;

public class BlogTestHelper {

	public static final String TEST_ID = "vId_1";

	public static Blog buildBlog(String id, String titleTxt, String contentTxt) {
		BlogId blogId = new BlogId(id);
		Title title = new Title(titleTxt);
		Content content = new Content(contentTxt);
		Blog blog = new Blog(blogId, title, content);
		return blog;
	}

	public static Blog buildBlogExample(){
		return BlogTestHelper.buildBlog(TEST_ID, "blog" + " : " + new Date(), "content" + " : " + new Date());
	}
}
