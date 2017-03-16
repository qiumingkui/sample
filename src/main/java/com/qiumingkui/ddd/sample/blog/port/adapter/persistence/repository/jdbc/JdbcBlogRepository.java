package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository.jdbc;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.ddd.sample.blog.domain.model.Blog;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogId;
import com.qiumingkui.ddd.sample.blog.port.adapter.persistence.dao.BlogDao;
import com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository.BlogRepository;

@Service
public class JdbcBlogRepository implements BlogRepository {

	@Autowired
	private BlogDao blogDao;

	@Override
	@Transactional(readOnly = true)
	public Blog get(BlogId aBlogId) {
		return blogDao.retrieve(aBlogId);
	}

	@Override
	public void save(Blog aBlog) {
		Blog retrieveBlog = blogDao.retrieve(aBlog.blogId());
		if (retrieveBlog != null) {
			blogDao.update(aBlog);
		} else {
			blogDao.create(aBlog);
		}
	}

	@Override
	public void del(BlogId aBlogId) {
		blogDao.delete(aBlogId);
	}

}
