package com.qiumingkui.sample.imedia.mp.domain.model.category;

import java.io.Serializable;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CategoryId categoryId;

	private CategoryId parentId;

	private String name;

	private String description;

	private CategoryPost categoryPost;

	private Category() {
		super();
	}

	protected Category(CategoryId aCategoryId, CategoryId aParentId, String aName, String aDescription,CategoryPost aCategoryPost) {
		this();
		this.setCategoryId(aCategoryId);
		this.setParentId(aParentId);
		this.setName(aName);
		this.setDescription(aDescription);
		this.setCategoryPost(aCategoryPost);
	}

	public CategoryId categoryId() {
		return categoryId;
	}

	public CategoryId parentId() {
		return parentId;
	}

	public String name() {
		return name;
	}

	public String description() {
		return description;
	}

	public CategoryPost categoryPost() {
		return categoryPost;
	}

	private void setCategoryId(CategoryId categoryId) {
		this.categoryId = categoryId;
	}

	private void setParentId(CategoryId parentId) {
		this.parentId = parentId;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	private void setCategoryPost(CategoryPost categoryPost) {
		this.categoryPost = categoryPost;
	}

}
