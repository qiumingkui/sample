package com.qiumingkui.sample.imedia.mp.domain.model.category;

import java.io.Serializable;

public class PostCategoryData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static PostCategoryData create(PostCategory aPostCategory) {
		return new PostCategoryData(aPostCategory.postCategoryId().postId(),
				aPostCategory.postCategoryId().categoryId());
	}

	private String postId;

	private String categoryId;

	public PostCategoryData(String postId, String categoryId) {
		super();
		this.postId = postId;
		this.categoryId = categoryId;
	}

	public String getPostId() {
		return postId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

}
