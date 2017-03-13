package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository;

import java.util.Date;

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
import com.qiumingkui.ddd.sample.blog.domain.model.BlogTestHelper;
import com.qiumingkui.ddd.sample.blog.domain.model.Title;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {
	private static final Logger log = LoggerFactory.getLogger(BlogRepositoryTest.class);
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
		log.info("testGenId() genId:" + blogRepository.genId().id());
	}

	@Test
	@Transactional
	public void testGet() {
		Blog blog = BlogTestHelper.buildBlogExample();
		blogRepository.save(blog);

		blog = blogRepository.get(new BlogId(BlogTestHelper.TEST_ID));
		log.info("testGet() blog title:" + blog.title().titleTxt());
	}

	@Test
	@Transactional
	public void testSave() {
		Blog blog = BlogTestHelper.buildBlogExample();
		blogRepository.save(blog);

		blog = blogRepository.get(new BlogId(BlogTestHelper.TEST_ID));
		Title oldTitle = blog.title();

		Title newTitle = new Title("blog" + " : this is new :" + new Date());
		blog.changeTitle(newTitle);
		blogRepository.save(blog);

		log.info("testSave() blog " + " old title:" + oldTitle.titleTxt() + "new title:" + blog.title().titleTxt());
	}

	@Test
	@Transactional
	public void testDel() {
		Blog blog = BlogTestHelper.buildBlogExample();
		blogRepository.save(blog);
		
		BlogId blogId = new BlogId(BlogTestHelper.TEST_ID);
		blogRepository.del(blogId);
		
		log.info("testDelete() blogId:" + blogId.id());
	}
	
}
