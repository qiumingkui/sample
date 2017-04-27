package com.qiumingkui.sample.imedia.blog.domain.model.category;

import com.qiumingkui.sample.imedia.common.ext.entity.IdentityEntity;

public class BlogEntryCategory implements IdentityEntity<BlogEntryCategoryId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BlogEntryCategoryId id;

	private BlogEntryCategory() {
		super();
	}

	public BlogEntryCategory(BlogEntryCategoryId aBlogEntryCategoryId) {
		this();
		this.setId(aBlogEntryCategoryId);
	}

	private void setId(BlogEntryCategoryId aBlogEntryCategoryId) {
		this.id = aBlogEntryCategoryId;
	}

	@Override
	public BlogEntryCategoryId id() {
		return id;
	}

}
