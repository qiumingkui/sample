package com.qiumingkui.sample.imedia.mp.domain.model.category;

public class PostCategoryFactory {

	public static PostCategory create(String aPostId, String aCategoryId) {
			
		return new PostCategory(new PostCategoryId(aPostId, aCategoryId));
	}

}
