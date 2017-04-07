package com.qiumingkui.sample.imedia.mp.domain.model.category;

import com.qiumingkui.sample.imedia.common.domain.id.CompositeId;

public class PostCategoryId implements CompositeId<PostCategoryId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String postId;

	private String categoryId;

	private PostCategoryId() {
		super();
	}

	public PostCategoryId(String aPostId, String aCategoryId) {
		this();
		this.setPostId(aPostId);
		this.setCategoryId(aCategoryId);
	}

	public String postId() {
		return postId;
	}

	public String categoryId() {
		return categoryId;
	}

	private void setPostId(String postId) {
		this.postId = postId;
	}

	private void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public boolean equals(PostCategoryId aPostCategoryId) {

		if (aPostCategoryId == null)
			return false;

		if (aPostCategoryId.postId() != null && aPostCategoryId.postId().equals(this.postId())) {
			if (aPostCategoryId.categoryId() != null && aPostCategoryId.categoryId().equals(this.categoryId()))
				return true;
		}

		return false;
	}
}
