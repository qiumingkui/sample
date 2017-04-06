package com.qiumingkui.sample.imedia.mp.domain.model.category;

public interface PostCategoryRepository {

	public PostCategory get(PostCategoryId aPostCategoryId);

	public void save(PostCategory aPostCategory);

	public void del(PostCategoryId aPostCategoryId);

}
