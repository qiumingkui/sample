package com.qiumingkui.sample.imedia.blog.domain.model.category;

import com.qiumingkui.sample.imedia.common.ext.entity.IdentityEntity;

public class PostCategory implements IdentityEntity<PostCategoryId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PostCategoryId id;

	private PostCategory() {
		super();
	}

	protected PostCategory(PostCategoryId aPostCategoryId) {
		this();
		this.setId(aPostCategoryId);
	}

	private void setId(PostCategoryId aPostCategoryId) {
		this.id = aPostCategoryId;
	}

	@Override
	public PostCategoryId id() {
		return id;
	}

}
