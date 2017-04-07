package com.qiumingkui.sample.imedia.blog.domain.model.category;

import com.qiumingkui.sample.imedia.common.domain.entity.ConcurrencyEntity;
import com.qiumingkui.sample.imedia.common.domain.entity.IdentityEntity;
import com.qiumingkui.sample.imedia.common.domain.version.ConcurrencyVersion;
import com.qiumingkui.sample.imedia.common.util.AssertionUtil;

public class Category implements IdentityEntity<CategoryId>, ConcurrencyEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CategoryId id;

	private CategoryId parentId;

	private String name;

	private String description;

	private CategoryPostVal postVal;

	private ConcurrencyVersion version;

	protected Category() {
		super();
	}

	public Category create(CategoryId aId, CategoryId aParentId, String aName, String aDescription,
			CategoryPostVal aPostVal) {

		this.init(aId, aParentId, aName, aDescription, aPostVal, new ConcurrencyVersion(-1));

		return this;
	}

	protected void init(CategoryId aId, CategoryId aParentId, String aName, String aDescription,
			CategoryPostVal aPostVal, ConcurrencyVersion aVersion) {
		this.setId(aId);
		this.setParentId(aParentId);
		this.setName(aName);
		this.setDescription(aDescription);
		this.setPostVal(aPostVal);
		this.setVersion(aVersion);
	}

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

	public CategoryPostVal postVal() {
		return postVal;
	}

	public long postNumber() {
		return this.postVal().postNumber();
	}

	@Override
	public ConcurrencyVersion version() {
		return this.version;
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

	private void setPostVal(CategoryPostVal aPostVal) {
		AssertionUtil.assertArgumentTrue(aPostVal.postNumber() >= 0, "PostNumber can't < 0 !");
		this.postVal = aPostVal;
	}

	private void setVersion(ConcurrencyVersion aVersion) {
		this.version = aVersion;
	}

}
