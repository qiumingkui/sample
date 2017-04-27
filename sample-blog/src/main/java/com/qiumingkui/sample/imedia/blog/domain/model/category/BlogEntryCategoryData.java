package com.qiumingkui.sample.imedia.blog.domain.model.category;

import java.io.Serializable;

public class BlogEntryCategoryData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static BlogEntryCategoryData create(BlogEntryCategory aBlogEntryCategory) {
		return new BlogEntryCategoryData(aBlogEntryCategory.id().blogEntryId(), aBlogEntryCategory.id().categoryId());
	}

	private String blogEntryId;

	private String categoryId;

	public BlogEntryCategoryData(String aBlogEntryId, String aCategoryId) {
		super();
		this.setBlogEntryId(aBlogEntryId);
		this.setCategoryId(aCategoryId);
	}

	public String blogEntryId() {
		return blogEntryId;
	}

	public String categoryId() {
		return categoryId;
	}

	private void setBlogEntryId(String aBlogEntryId) {
		this.blogEntryId = aBlogEntryId;
	}

	private void setCategoryId(String aCategoryId) {
		this.categoryId = aCategoryId;
	}

}
