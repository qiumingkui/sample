package com.qiumingkui.sample.imedia.blog.domain.model.category;

import com.qiumingkui.sample.imedia.common.ext.id.CompositeId;

public class BlogEntryCategoryId implements CompositeId<BlogEntryCategoryId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String blogEntryId;

	private String categoryId;

	private BlogEntryCategoryId() {
		super();
	}

	public BlogEntryCategoryId(String aBlogEntry, String aCategoryId) {
		this();
		this.setBlogEntry(aBlogEntry);
		this.setCategoryId(aCategoryId);
	}

	public String blogEntryId() {
		return blogEntryId;
	}

	public String categoryId() {
		return categoryId;
	}

	private void setBlogEntry(String postId) {
		this.blogEntryId = postId;
	}

	private void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public boolean equals(BlogEntryCategoryId aBlogEntryCategoryId) {

		if (aBlogEntryCategoryId == null)
			return false;

		if (aBlogEntryCategoryId.blogEntryId() != null && aBlogEntryCategoryId.blogEntryId().equals(this.blogEntryId())) {
			if (aBlogEntryCategoryId.categoryId() != null && aBlogEntryCategoryId.categoryId().equals(this.categoryId()))
				return true;
		}

		return false;
	}
}
