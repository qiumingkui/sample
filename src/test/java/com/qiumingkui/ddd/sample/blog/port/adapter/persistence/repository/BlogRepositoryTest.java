package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.ddd.sample.blog.domain.model.BlogId;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {

	protected BlogRepository blogRepository;

	public BlogRepository getBlogRepository() {
		return blogRepository;
	}

	@Autowired
	public void setBlogRepository(JdbcBlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

	@Test
	public void testGet() {
		// blogRepository.get(new BlogId("1"));
		System.out.println("genId:" + blogRepository.genId().id());
		System.out.println("get:" + blogRepository.get(new BlogId("1")).title().titleText());

	}
}
