package com.qiumingkui.sample.imedia.blog.domain.model.category;

public class BlogEntryCategoryFactory {

	public static BlogEntryCategory create(String aBlogEntryId, String aCategoryId) {
			
		return new BlogEntryCategory(new BlogEntryCategoryId(aBlogEntryId, aCategoryId));
	}

}
