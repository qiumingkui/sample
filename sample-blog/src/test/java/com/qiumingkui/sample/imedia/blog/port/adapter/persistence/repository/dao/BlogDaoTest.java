package com.qiumingkui.sample.imedia.blog.port.adapter.persistence.repository.dao;

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

import com.qiumingkui.sample.imedia.blog.domain.model.Title;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntry;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryId;
import com.qiumingkui.sample.imedia.blog.helper.BlogEntryTestHelper;
import com.qiumingkui.sample.imedia.blog.port.adapter.persistence.dao.BlogEntryDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogDaoTest {

	private static final Logger log = LoggerFactory.getLogger(BlogDaoTest.class);

	@Autowired
	protected BlogEntryDao blogEntryDao;

	@Test
	@Transactional
	public void testCreate() {
		BlogEntry blogEntry = BlogEntryTestHelper.buildBlogEntryExample();
		blogEntryDao.create(blogEntry);
		assertThat(blogEntry.id().key().isEmpty()).isFalse();
	}

	@Test
	@Transactional
	public void testUpdate() {
		BlogEntry blogEntry = BlogEntryTestHelper.buildBlogEntryExample();
		blogEntryDao.create(blogEntry);

		BlogEntryId blogId = blogEntry.id();
		blogEntry = blogEntryDao.retrieve(blogId);
		Timestamp odlModifyTime = blogEntry.modifyTime();

		Title newTitle = new Title("blog" + " : this is new :" + new Date());
		blogEntry.changeTitle(newTitle);
		blogEntryDao.update(blogEntry);

		// blog = blogDao.retrieve(blogId);
		assertThat(blogEntry.modifyTime().after(odlModifyTime)).isTrue();
	}

	@Test
	@Transactional
	public void testRetrieve() {
		BlogEntry blogEntry = BlogEntryTestHelper.buildBlogEntryExample();
		String account = blogEntry.blogAuthor().account();
		blogEntryDao.create(blogEntry);

		BlogEntryId blogId = blogEntry.id();
		blogEntry = blogEntryDao.retrieve(blogId);

		// log.info("testRetrieve() blogId:" + blog.blogId().id() + ",title:" +
		// blog.title().titleTxt());
		assertThat(blogEntry.blogAuthor().account().equals(account)).isTrue();
	}

	@Test
	@Transactional
	public void testDelete() {
		BlogEntry blogEntry = BlogEntryTestHelper.buildBlogEntryExample();
		blogEntryDao.create(blogEntry);

		BlogEntryId blogId = blogEntry.id();
		blogEntryDao.delete(blogId);

		log.info("testDelete() blogId:" + blogId.key());
	}

}
