package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.iwords.blog.domain.model.Blog;
import com.qiumingkui.sample.iwords.blog.domain.model.BlogBuilder;
import com.qiumingkui.sample.iwords.blog.domain.model.BlogId;
import com.qiumingkui.sample.iwords.blog.domain.model.Title;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.BlogRepository;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.jdbc.JdbcBlogRepository;

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
	@Transactional
	public void testGet() {
		Blog blog = buildBlogExample();
		blogRepository.save(blog);

		blog = blogRepository.get(blog.blogId());
		log.info("testGet() blog title:" + blog.title().titleTxt());
	}

	@Test
	@Transactional
	// @Commit
	public void testSave() {
		Blog blog = buildBlogExample();
		blogRepository.save(blog);

		blog = blogRepository.get(blog.blogId());
		Title oldTitle = blog.title();

		Title newTitle = new Title("blog" + " : this is new :" + new Date());
		blog.changeTitle(newTitle);
		blogRepository.save(blog);

		log.info("testSave() blog id:"+blog.blogId().id() + " old title:" + oldTitle.titleTxt() + "new title:" + blog.title().titleTxt());
	}

	@Test
	@Transactional
	public void testDel() {
		Blog blog = buildBlogExample();
		blogRepository.save(blog);
		
		BlogId blogId = blog.blogId();
		blogRepository.del(blogId);
		
		log.info("testDelete() blogId:" + blogId.id());
	}
	
	private Blog buildBlogExample() {
		return BlogBuilder.build("blog" + " : " + new Date(), "content" + " : " + new Date());
	}
}
