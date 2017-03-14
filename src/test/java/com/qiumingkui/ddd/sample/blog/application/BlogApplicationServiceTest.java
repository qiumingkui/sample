package com.qiumingkui.ddd.sample.blog.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.ddd.sample.blog.domain.model.BlogData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationServiceTest {
	// private static final Logger log =
	// LoggerFactory.getLogger(BlogApplicationServiceTest.class);

	@Autowired
	private BlogApplicationService blogApplicationService;

	@Test
	@Transactional
	public void testPublishBlog() {
		String blogId = blogApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date());
		assertThat(blogId.isEmpty());
	}

	@Test
	@Transactional
	public void testFindBlog() {
		String blogId = blogApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date());
		BlogData blogData = blogApplicationService.findBlog(blogId);
		assertThat(blogData.getBlogId().isEmpty());
	}

	@Test
	@Transactional
	@Commit
	public void testModifyBlog() {
		String blogId = blogApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date());
		BlogData blogData = blogApplicationService.findBlog(blogId);
		blogApplicationService.modifyBlog(blogId, "aTitle modify:" + new Date(), "aContent modify:" + new Date());
		assertThat(blogData.getBlogId().isEmpty());
	}

}
