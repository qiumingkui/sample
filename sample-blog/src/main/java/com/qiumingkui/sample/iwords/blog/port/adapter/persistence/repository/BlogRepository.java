package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository;

import com.qiumingkui.sample.iwords.blog.domain.model.blog.Blog;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.BlogId;

public interface BlogRepository {

	public Blog get(BlogId aBlogId);

	public void save(Blog aBlog);

	public void del(BlogId aBlogId);

}
