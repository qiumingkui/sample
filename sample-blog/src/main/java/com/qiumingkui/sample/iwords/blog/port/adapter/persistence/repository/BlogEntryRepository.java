package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository;

import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntry;
import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntryId;

public interface BlogEntryRepository {

	public BlogEntry get(BlogEntryId aBlogId);

	public void save(BlogEntry aBlog);

	public void del(BlogEntryId aBlogId);

}
