package com.qiumingkui.sample.imedia.mp.domain.model.category;

public interface CategoryRepository {

	public Category get(CategoryId aCategoryId);

	public void save(Category aCategory);

	public void del(CategoryId aCategoryId);

}
