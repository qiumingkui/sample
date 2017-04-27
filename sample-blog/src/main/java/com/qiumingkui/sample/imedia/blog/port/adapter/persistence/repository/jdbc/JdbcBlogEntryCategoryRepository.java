package com.qiumingkui.sample.imedia.blog.port.adapter.persistence.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiumingkui.sample.imedia.blog.domain.model.category.BlogEntryCategoryRepository;
import com.qiumingkui.sample.imedia.blog.domain.model.category.BlogEntryCategory;
import com.qiumingkui.sample.imedia.blog.domain.model.category.BlogEntryCategoryId;
import com.qiumingkui.sample.imedia.blog.port.adapter.persistence.dao.BlogEntryCategoryDao;

@Service
public class JdbcBlogEntryCategoryRepository implements BlogEntryCategoryRepository {
	@Autowired
	private BlogEntryCategoryDao blogEntryCategoryDao;

	public BlogEntryCategory get(BlogEntryCategoryId aBlogEntryCategoryId) {
		return blogEntryCategoryDao.retrieve(aBlogEntryCategoryId);
	}

	public void save(BlogEntryCategory aBlogEntryCategory) {
		BlogEntryCategory retrieveBlogEntryCategory = blogEntryCategoryDao.retrieve(aBlogEntryCategory.id());
		if (retrieveBlogEntryCategory == null) {
			blogEntryCategoryDao.create(aBlogEntryCategory);
		}
	}

	public void del(BlogEntryCategoryId aBlogEntryCategoryId) {
		blogEntryCategoryDao.delete(aBlogEntryCategoryId);
	}
}
