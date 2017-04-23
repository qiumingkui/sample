package com.qiumingkui.sample.imedia.blog.port.adapter.persistence.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntry;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryId;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryRepository;
import com.qiumingkui.sample.imedia.blog.port.adapter.persistence.dao.BlogEntryDao;


@Service
public class JdbcBlogEntryRepository implements BlogEntryRepository {

	@Autowired
	private BlogEntryDao blogEntryDao;

	@Override
	@Transactional(readOnly = true)
	public BlogEntry get(BlogEntryId aBlogEntryId) {
		return blogEntryDao.retrieve(aBlogEntryId);
	}

	@Override
	public void save(BlogEntry aBlogEntry) {
		BlogEntry retrieveBlogEntry = blogEntryDao.retrieve(aBlogEntry.id());
		if (retrieveBlogEntry != null) {
			blogEntryDao.update(aBlogEntry);
		} else {
			blogEntryDao.create(aBlogEntry);
		}
	}

	@Override
	public void del(BlogEntryId aBlogEntryId) {
		blogEntryDao.delete(aBlogEntryId);
	}

}
