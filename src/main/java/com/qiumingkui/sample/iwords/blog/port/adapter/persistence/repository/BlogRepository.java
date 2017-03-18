package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository;

import com.qiumingkui.sample.iwords.blog.domain.model.Blog;
import com.qiumingkui.sample.iwords.blog.domain.model.BlogId;

public interface BlogRepository {

	public Blog get(BlogId aBlogId);

	public void save(Blog aBlog);

	public void del(BlogId aBlogId);

}
