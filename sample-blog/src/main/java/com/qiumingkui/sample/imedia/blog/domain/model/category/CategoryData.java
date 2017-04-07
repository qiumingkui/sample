package com.qiumingkui.sample.imedia.blog.domain.model.category;

import java.io.Serializable;

public class CategoryData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static CategoryData create(Category aCategory) {
		CategoryData data = new CategoryData(aCategory.id().key(), aCategory.parentId().key(), aCategory.name(),
				aCategory.description(), aCategory.postNumber());
		return data;
	}

	private String categoryId;

	private String parentId;

	private String name;

	private String description;

	private long postNumber;
	
	public CategoryData(String categoryId, String parentId, String name, String description, long postNumber) {
		super();
		this.categoryId = categoryId;
		this.parentId = parentId;
		this.name = name;
		this.description = description;
		this.postNumber = postNumber;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public String getParentId() {
		return parentId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public long getPostNumber() {
		return postNumber;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPostNumber(long postNumber) {
		this.postNumber = postNumber;
	}
	
	
}
