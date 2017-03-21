package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.memory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.qiumingkui.sample.iwords.blog.domain.model.blog.Blog;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.BlogId;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.BlogRepository;

@Service
public class MemoryBlogRepository implements BlogRepository {

	private static Map<String, Blog> cache = new HashMap<String, Blog>();

	@Override
	public Blog get(BlogId aBlogId) {
		return cache.get(aBlogId.id());
	}

	@Override
	public void save(Blog aBlog) {
		cache.put(aBlog.blogId().id(), aBlog);

	}

	@Override
	public void del(BlogId aBlogId) {
		cache.remove(aBlogId.id());
	}

}
