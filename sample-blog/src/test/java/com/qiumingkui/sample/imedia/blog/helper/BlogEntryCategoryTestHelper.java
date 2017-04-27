package com.qiumingkui.sample.imedia.blog.helper;

import com.qiumingkui.sample.imedia.blog.domain.model.category.BlogEntryCategory;
import com.qiumingkui.sample.imedia.blog.domain.model.category.BlogEntryCategoryFactory;

public class BlogEntryCategoryTestHelper {

	public static BlogEntryCategory buildBlogEntryCategoryExample(){
		
		BlogEntryCategory blogEntryCategory = BlogEntryCategoryFactory.create("blogEntryId:1", "categoryId:1");
		
		return blogEntryCategory ;
	}
}
