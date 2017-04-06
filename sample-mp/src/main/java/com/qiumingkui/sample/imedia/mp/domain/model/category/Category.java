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

	private CategoryPostVal categoryPostVal;

	private Category() {
		super();
	}

	protected Category(CategoryId aCategoryId, CategoryId aParentId, String aName, String aDescription,CategoryPostVal aCategoryPostVal) {
		this();
		this.setCategoryId(aCategoryId);
		this.setParentId(aParentId);
		this.setName(aName);
		this.setDescription(aDescription);
		this.setCategoryPostVal(aCategoryPostVal);
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

	public CategoryPostVal categoryPostVal() {
		return categoryPostVal;
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

	private void setCategoryPostVal(CategoryPostVal categoryPostVal) {
		this.categoryPostVal = categoryPostVal;
	}

}
