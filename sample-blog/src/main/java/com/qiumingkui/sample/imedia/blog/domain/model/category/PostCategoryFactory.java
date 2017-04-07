package com.qiumingkui.sample.imedia.blog.domain.model.category;

public class PostCategoryFactory {

	public static PostCategory create(String aPostId, String aCategoryId) {
			
		return new PostCategory(new PostCategoryId(aPostId, aCategoryId));
	}

}
