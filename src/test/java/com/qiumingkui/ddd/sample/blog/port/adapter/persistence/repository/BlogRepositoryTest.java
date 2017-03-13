package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.ddd.sample.blog.domain.model.Blog;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogId;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {
	private static final Logger log = LoggerFactory.getLogger(BlogRepositoryTest.class);
	private static final String TEST_ID = "1";

	protected BlogRepository blogRepository;

	public BlogRepository getBlogRepository() {
		return blogRepository;
	}

	@Autowired
	public void setBlogRepository(JdbcBlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

	@Test
	public void testGenId() {
		log.info("testGet() genId:" + blogRepository.genId().id());
	}
	
	@Test
	@Transactional
	public void testGet() {
		Blog blog = blogRepository.get(new BlogId(TEST_ID));
		log.info("testGet() blog title:" + blog.title().titleTxt());
	}
}
