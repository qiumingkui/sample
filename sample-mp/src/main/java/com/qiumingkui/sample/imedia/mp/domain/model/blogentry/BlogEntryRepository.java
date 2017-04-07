package com.qiumingkui.sample.imedia.mp.domain.model.blogentry;

public interface BlogEntryRepository {

	public BlogEntry get(BlogEntryId aBlogId);

	public void save(BlogEntry aBlog);

	public void del(BlogEntryId aBlogId);

}
