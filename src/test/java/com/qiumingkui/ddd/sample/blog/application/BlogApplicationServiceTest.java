package com.qiumingkui.ddd.sample.blog.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogData;
import com.qiumingkui.ddd.sample.blog.domain.model.BlogStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationServiceTest {

	@Autowired
	private BlogApplicationService blogApplicationService;

	@Test
	public void publishBlog() {
		String title = "aTitle:" + new Date();
		String content = "aContent:" + new Date();
		String blogId = blogApplicationService.publishBlog(title, content);
		assertThat(blogId.isEmpty()).isFalse();
	}

	@Test
	public void readBlog() {
		String title = "aTitle:" + new Date();
		String content = "aContent:" + new Date();
		String blogId = blogApplicationService.publishBlog(title, content);
		BlogData blogData = blogApplicationService.readBlog(blogId);
		assertThat(blogData.getTitle().equals(title)).isTrue();
	}

	@Test
	public void modifyBlog() {
		String blogId = blogApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date());
		BlogData blogData = blogApplicationService.readBlog(blogId);
		String title = "aTitle modify:" + new Date();
		String content = "aContent modify:" + new Date();
		blogApplicationService.modifyBlog(blogId, title, content);
		blogData = blogApplicationService.readBlog(blogId);
		assertThat(blogData.getTitle().equals(title)).isTrue();
	}

	@Test
	public void lockBlog() {
		String blogId = blogApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date());
		blogApplicationService.lockBlog(blogId);
		BlogData blogData = blogApplicationService.readBlog(blogId);
		assertThat(blogData.getStatus() == BlogStatus.CLOSE).isFalse();
		assertThat(blogData.getStatus() == BlogStatus.LOCK).isTrue();
	}

	@Test
	public void closeBlog() {
		String blogId = blogApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date());
		blogApplicationService.closeBlog(blogId);
		BlogData blogData = blogApplicationService.readBlog(blogId);
		assertThat(blogData.getStatus() == BlogStatus.CLOSE).isTrue();
		assertThat(blogData.getStatus() == BlogStatus.LOCK).isFalse();
	}

	@Test
	public void reopenBlog() {
		String blogId = blogApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date());
		blogApplicationService.reopenBlog(blogId);
		BlogData blogData = blogApplicationService.readBlog(blogId);
		assertThat(blogData.getStatus() == BlogStatus.REOPEN).isTrue();
		assertThat(blogData.getStatus() == BlogStatus.ISSUE).isFalse();
	}

	
}
