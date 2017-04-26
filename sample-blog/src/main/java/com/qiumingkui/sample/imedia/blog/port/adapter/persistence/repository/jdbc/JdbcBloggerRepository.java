package com.qiumingkui.sample.imedia.blog.port.adapter.persistence.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.imedia.blog.domain.model.blogger.Blogger;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.BloggerId;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.BloggerRepository;
import com.qiumingkui.sample.imedia.blog.port.adapter.persistence.dao.BloggerDao;

@Service
public class JdbcBloggerRepository implements BloggerRepository {

	@Autowired
	private BloggerDao bloggerDao;


	@Transactional(readOnly = true)
	public Blogger get(BloggerId aBloggerId) {
		return bloggerDao.retrieve(aBloggerId);
	}

	public void save(Blogger aBlogger) {
		Blogger retrieveBlogger = bloggerDao.retrieve(aBlogger.id());
		if (retrieveBlogger != null) {
			bloggerDao.update(aBlogger);
		} else {
			bloggerDao.create(aBlogger);
		}
	}

	public void del(BloggerId aBloggerId) {
		bloggerDao.delete(aBloggerId);
	}


}
