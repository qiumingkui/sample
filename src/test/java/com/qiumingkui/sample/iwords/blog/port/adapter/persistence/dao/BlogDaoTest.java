package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.dao;

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

import com.qiumingkui.sample.iwords.blog.domain.model.Blog;
import com.qiumingkui.sample.iwords.blog.domain.model.BlogBuilder;
import com.qiumingkui.sample.iwords.blog.domain.model.BlogId;
import com.qiumingkui.sample.iwords.blog.domain.model.MemberTestHelper;
import com.qiumingkui.sample.iwords.blog.domain.model.Title;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;
import com.qiumingkui.sample.iwords.blog.domain.model.member.MemberBuilder;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Person;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.dao.BlogDao;

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
		Timestamp odlModifyTime = blog.modifyTime();

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
		String account = blog.author().account();
		blogDao.create(blog);

		BlogId blogId = blog.blogId();
		blog = blogDao.retrieve(blogId);

		// log.info("testRetrieve() blogId:" + blog.blogId().id() + ",title:" +
		// blog.title().titleTxt());
		assertThat(blog.author().account().equals(account)).isTrue();
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
		Person person = MemberTestHelper.buildPerson4CommonUserExample();
		Author author = MemberBuilder.buildAuthor(person);
		return BlogBuilder.build("blog" + " : " + new Date(), "content" + " : " + new Date(), author);
	}
}
