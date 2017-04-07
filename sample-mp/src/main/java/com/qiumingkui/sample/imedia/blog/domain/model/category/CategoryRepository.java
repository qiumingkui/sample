package com.qiumingkui.sample.imedia.blog.domain.model.category;

public interface CategoryRepository {

	public Category get(CategoryId aCategoryId);

	public void save(Category aCategory);

	public void del(CategoryId aCategoryId);

}
