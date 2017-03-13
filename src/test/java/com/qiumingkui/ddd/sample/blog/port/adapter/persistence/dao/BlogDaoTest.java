package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.dao;

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
public class BlogDaoTest {

	private static final Logger log = LoggerFactory.getLogger(BlogDaoTest.class);

	@Autowired
	protected BlogDao blogDao;


	@Test
	@Transactional
	public void testCreate() {
		Blog blog = BlogTestHelper.buildBlogExample();
		blogDao.create(blog);
		
		log.info("testCreate() blogId:" + blog.blogId().id() + ",title:" + blog.title().titleTxt());
	}

	@Test
	@Transactional
	public void testUpdate() {
		Blog blog = BlogTestHelper.buildBlogExample();
		blogDao.create(blog);
	
		BlogId blogId = new BlogId(BlogTestHelper.TEST_ID);
		blog = blogDao.retrieve(blogId);
		Title oldTitle= blog.title();
		
		Title newTitle = new Title("blog" + " : this is new :" + new Date());
		blog.changeTitle(newTitle);
		blogDao.update(blog);
		
		log.info("testUpdate() blogId:" + blog.blogId().id() + ",old Title:"+oldTitle.titleTxt()+",new title:" + blog.title().titleTxt());
	}

	@Test
	@Transactional
	public void testRetrieve() {
		Blog blog = BlogTestHelper.buildBlogExample();
		blogDao.create(blog);

		BlogId blogId = new BlogId(BlogTestHelper.TEST_ID);
		blog = blogDao.retrieve(blogId);
		
		log.info("testRetrieve() blogId:" + blog.blogId().id() + ",title:" + blog.title().titleTxt());
	}

	@Test
	@Transactional
	public void testDelete() {
		Blog blog = BlogTestHelper.buildBlogExample();
		blogDao.create(blog);
		
		BlogId blogId = new BlogId(BlogTestHelper.TEST_ID);
		blogDao.delete(blogId);
		
		log.info("testDelete() blogId:" + blogId.id());
	}


}
