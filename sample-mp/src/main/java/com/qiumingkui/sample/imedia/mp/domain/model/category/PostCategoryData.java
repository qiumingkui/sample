package com.qiumingkui.sample.imedia.mp.domain.model.category;

import java.io.Serializable;

public class PostCategoryData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static PostCategoryData create(PostCategory aPostCategory) {
		return new PostCategoryData(aPostCategory.id().postId(), aPostCategory.id().categoryId());
	}

	private String postId;

	private String categoryId;

	public PostCategoryData(String aPostId, String aCategoryId) {
		super();
		this.postId = aPostId;
		this.categoryId = aCategoryId;
	}

	public String getPostId() {
		return postId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setPostId(String aPostId) {
		this.postId = aPostId;
	}

	public void setCategoryId(String aCategoryId) {
		this.categoryId = aCategoryId;
	}

}
