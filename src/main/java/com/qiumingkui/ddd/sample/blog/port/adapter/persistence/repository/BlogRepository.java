package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository;

import com.qiumingkui.ddd.sample.blog.domain.model.Blog;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogId;

public interface BlogRepository {

	public Blog get(BlogId blogId);

	public BlogId genId();

	public void save(Blog blog);
	
	public void del(Blog blog);

}
