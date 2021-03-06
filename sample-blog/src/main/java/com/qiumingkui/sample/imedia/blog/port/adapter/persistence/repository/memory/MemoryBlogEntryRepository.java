package com.qiumingkui.sample.imedia.blog.port.adapter.persistence.repository.memory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntry;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryId;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryRepository;

//@Service
public class MemoryBlogEntryRepository implements BlogEntryRepository {

	private static Map<String, BlogEntry> cache = new HashMap<String, BlogEntry>();

	@Override
	public BlogEntry get(BlogEntryId aBlogId) {
		return cache.get(aBlogId.key());
	}

	@Override
	public void save(BlogEntry aBlog) {
		cache.put(aBlog.id().key(), aBlog);

	}

	@Override
	public void del(BlogEntryId aBlogId) {
		cache.remove(aBlogId.key());
	}

}
