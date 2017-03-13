package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.ddd.sample.blog.domain.model.Blog;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogId;
import com.qiumingkui.ddd.sample.blog.port.adapter.persistence.dao.BlogDao;

@Service
public class JdbcBlogRepository implements BlogRepository {

	@Autowired
	private BlogDao blogDao;

	@Override
	@Transactional(readOnly = true)
	public Blog get(BlogId blogId) {
		return blogDao.retrieve(blogId);
	}

	@Override
	public BlogId genId() {
		return new BlogId(UUID.randomUUID().toString().toUpperCase());
	}

	@Override
	public void save(Blog blog) {
		Blog retrieveBlog = blogDao.retrieve(blog.blogId());
		if (retrieveBlog != null) {
			blogDao.update(blog);
		} else {
			blogDao.create(blog);
		}
	}

	@Override
	public void del(BlogId blogId) {
		blogDao.delete(blogId);
	}

}
