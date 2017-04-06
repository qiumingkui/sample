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

	private CategoryPostVal postVal;

	private Category() {
		super();
	}

	protected Category(CategoryId aCategoryId, CategoryId aParentId, String aName, String aDescription,
			CategoryPostVal aPostVal) {
		this();
		this.setCategoryId(aCategoryId);
		this.setParentId(aParentId);
		this.setName(aName);
		this.setDescription(aDescription);
		this.setPostVal(aPostVal);
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

	public CategoryPostVal postVal() {
		return postVal;
	}

	public long postNumber() {
		return this.postVal().postNumber();
	}

	public void changeDescription(String aDescription) {
		this.setDescription(aDescription);
	}

	public void changePostNumber(long aPostNumber){
		CategoryPostVal newPostVal = new CategoryPostVal(aPostNumber);
		this.setPostVal(newPostVal);
	}
	
	public void addPostNumber(long addNumber) {
		synchronized (this) {
			long newPostNumber = this.postNumber() + addNumber;
			CategoryPostVal newPostVal = new CategoryPostVal(newPostNumber);
			this.setPostVal(newPostVal);
		}
	}

	private void setCategoryId(CategoryId aCategoryId) {
		this.categoryId = aCategoryId;
	}

	private void setParentId(CategoryId aParentId) {
		this.parentId = aParentId;
	}

	private void setName(String aName) {
		this.name = aName;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	private void setPostVal(CategoryPostVal aPostVal) {
		this.postVal = aPostVal;
	}

}
