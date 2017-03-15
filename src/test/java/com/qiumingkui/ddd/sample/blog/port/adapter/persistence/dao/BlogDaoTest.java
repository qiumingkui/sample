package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
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
import com.qiumingkui.ddd.sample.blog.domain.model.BlogBuilder;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogId;
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
		Blog blog = buildBlogExample();
		blogDao.create(blog);
		assertThat(blog.blogId().id().isEmpty()).isFalse();
	}

	@Test
	@Transactional
	public void testUpdate() {
		Blog blog = buildBlogExample();
		blogDao.create(blog);

		BlogId blogId = blog.blogId();
		blog = blogDao.retrieve(blogId);
		Timestamp odlModifyTime=blog.modifyTime();

		Title newTitle = new Title("blog" + " : this is new :" + new Date());
		blog.changeTitle(newTitle);
		blogDao.update(blog);

		// blog = blogDao.retrieve(blogId);
		assertThat(blog.modifyTime().after(odlModifyTime)).isTrue();
	}

	@Test
	@Transactional
	public void testRetrieve() {
		Blog blog = buildBlogExample();
		blogDao.create(blog);

		BlogId blogId = blog.blogId();
		blog = blogDao.retrieve(blogId);

		log.info("testRetrieve() blogId:" + blog.blogId().id() + ",title:" + blog.title().titleTxt());
	}

	@Test
	@Transactional
	public void testDelete() {
		Blog blog = buildBlogExample();
		blogDao.create(blog);

		BlogId blogId = blog.blogId();
		blogDao.delete(blogId);

		log.info("testDelete() blogId:" + blogId.id());
	}

	private Blog buildBlogExample() {
		return BlogBuilder.build("blog" + " : " + new Date(), "content" + " : " + new Date());
	}
}
