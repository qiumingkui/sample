package com.qiumingkui.sample.imedia.mp.domain.model.category;

import java.io.Serializable;

import com.qiumingkui.sample.imedia.common.EntityAssertion;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EntityAssertion assertion;

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

		this.assertion = new EntityAssertion();
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

	public void changePostNumber(long aPostNumber) {
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
		assertion.assertArgumentLength(aCategoryId.id(), 32, "CategoryId  is too lang!");
		this.categoryId = aCategoryId;
	}

	private void setParentId(CategoryId aParentId) {
		assertion.assertArgumentLength(aParentId.id(), 32, "ParentId  is too lang!");
		this.parentId = aParentId;
	}

	private void setName(String aName) {
		assertion.assertArgumentLength(aName, 128, "Name is too lang!");
		this.name = aName;
	}

	private void setDescription(String aDescription) {
		assertion.assertArgumentLength(aDescription, 1024, "Description is too lang!");
		this.description = aDescription;
	}

	private void setPostVal(CategoryPostVal aPostVal) {
		assertion.assertArgumentTrue(aPostVal.postNumber()<0,"PostNumber can't < 0 !");
		this.postVal = aPostVal;
	}

}
