package com.qiumingkui.sample.imedia.blog.domain.model.category;

public interface BlogEntryCategoryRepository {

	public BlogEntryCategory get(BlogEntryCategoryId aBlogEntryCategoryId);

	public void save(BlogEntryCategory aBlogEntryCategory);

	public void del(BlogEntryCategoryId aBlogEntryCategoryId);

}
