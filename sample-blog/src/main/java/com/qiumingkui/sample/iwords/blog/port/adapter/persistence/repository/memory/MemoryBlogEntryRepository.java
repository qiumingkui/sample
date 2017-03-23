package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.memory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntry;
import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntryId;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.BlogEntryRepository;

@Service
public class MemoryBlogEntryRepository implements BlogEntryRepository {

	private static Map<String, BlogEntry> cache = new HashMap<String, BlogEntry>();

	@Override
	public BlogEntry get(BlogEntryId aBlogId) {
		return cache.get(aBlogId.id());
	}

	@Override
	public void save(BlogEntry aBlog) {
		cache.put(aBlog.blogEntryId().id(), aBlog);

	}

	@Override
	public void del(BlogEntryId aBlogId) {
		cache.remove(aBlogId.id());
	}

}
