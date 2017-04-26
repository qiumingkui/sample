package com.qiumingkui.sample.imedia.blog.domain.model.category;

import com.qiumingkui.sample.imedia.common.ext.entity.ConcurrencyEntity;
import com.qiumingkui.sample.imedia.common.ext.entity.IdentityEntity;
import com.qiumingkui.sample.imedia.common.ext.util.AssertionUtil;
import com.qiumingkui.sample.imedia.common.ext.version.ConcurrencyVersion;

public class Category implements IdentityEntity<CategoryId>, ConcurrencyEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CategoryId id;

	private CategoryId parentId;

	private String name;

	private String description;

	private CategoryVal categoryVal;

	private ConcurrencyVersion version;

	private Category() {
		super();
	}

	public Category(CategoryId aId, CategoryId aParentId, String aName, String aDescription, CategoryVal aCategoryVal) {

		this();
		this.init(aId, aParentId, aName, aDescription, aCategoryVal, new ConcurrencyVersion(-1));

	}

	public Category(CategoryId aId, CategoryId aParentId, String aName, String aDescription, CategoryVal CategoryVal,
			ConcurrencyVersion aVersion) {
		this();
		this.init(aId, aParentId, aName, aDescription, CategoryVal, aVersion);

	}

	private void init(CategoryId aId, CategoryId aParentId, String aName, String aDescription, CategoryVal CategoryVal,
			ConcurrencyVersion aVersion) {
		this.setId(aId);
		this.setParentId(aParentId);
		this.setName(aName);
		this.setDescription(aDescription);
		this.setCategoryVal(CategoryVal);
		this.setVersion(aVersion);
	}

	@Override
	public CategoryId id() {
		return this.id;
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

	public CategoryVal categroyVal() {
		return categoryVal;
	}

	public ConcurrencyVersion version() {
		return this.version;
	}

	public void changeDescription(String aDescription) {
		this.setDescription(aDescription);
	}

	public void changePostNumber(long aPostNumber) {
		CategoryVal newPostVal = new CategoryVal(aPostNumber);
		this.setCategoryVal(newPostVal);
	}

	public void addPostNumber(long addNumber) {
		synchronized (this) {
			long newPostNumber = this.categoryVal.postNumber() + addNumber;
			CategoryVal newPostVal = new CategoryVal(newPostNumber);
			this.setCategoryVal(newPostVal);
		}
	}

	private void setId(CategoryId aCategoryId) {
		// AssertionUtil.assertArgumentLength(aCategoryId.id(), 32, "CategoryId
		// is too lang!");
		this.id = aCategoryId;
	}

	private void setParentId(CategoryId aParentId) {
		// AssertionUtil.assertArgumentLength(aParentId.key(), 32, "ParentId is
		// too lang!");
		this.parentId = aParentId;
	}

	private void setName(String aName) {
		AssertionUtil.assertArgumentLength(aName, 128, "Name is too lang!");
		this.name = aName;
	}

	private void setDescription(String aDescription) {
		AssertionUtil.assertArgumentLength(aDescription, 1024, "Description is too lang!");
		this.description = aDescription;
	}

	private void setCategoryVal(CategoryVal aPostVal) {
		AssertionUtil.assertArgumentTrue(aPostVal.postNumber() >= 0, "PostNumber can't < 0 !");
		this.categoryVal = aPostVal;
	}

	private void setVersion(ConcurrencyVersion aVersion) {
		this.version = aVersion;
	}

}
