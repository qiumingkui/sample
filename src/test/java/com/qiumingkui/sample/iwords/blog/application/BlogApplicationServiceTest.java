package com.qiumingkui.sample.iwords.blog.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.iwords.blog.application.BlogApplicationService;
import com.qiumingkui.sample.iwords.blog.domain.model.BlogData;
import com.qiumingkui.sample.iwords.blog.domain.model.BlogStatus;
import com.qiumingkui.sample.iwords.blog.domain.model.MemberTestHelper;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Person;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationServiceTest {

	@Autowired
	private PersonRepository personRepository;

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
		Person padmin = MemberTestHelper.buildPerson4AdminExample();
		Person pcommon = MemberTestHelper.buildPerson4CommonUserExample();
		Person anonymous = MemberTestHelper.buildPerson4AnonymousExample();
		personRepository.save(padmin);
		personRepository.save(pcommon);
		personRepository.save(anonymous);

		String blogId = blogApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date());

		String title = "aTitle modify by pcommon:" + new Date();
		String content = "aContent modify by pcommon:" + new Date();
		try {
			blogApplicationService.modifyBlog(blogId, title, content, pcommon.id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		BlogData blogData = blogApplicationService.readBlog(blogId);
		assertThat(blogData.getTitle().equals(title)).isTrue();

		title = "aTitle modify by padmin:" + new Date();
		content = "aContent modify by padmin:" + new Date();
		try {
			blogApplicationService.modifyBlog(blogId, title, content, padmin.id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		blogData = blogApplicationService.readBlog(blogId);
		assertThat(blogData.getTitle().equals(title)).isTrue();

		title = "aTitle modify by anonymous:" + new Date();
		content = "aContent modify by anonymous:" + new Date();
		try {
			blogApplicationService.modifyBlog(blogId, title, content, anonymous.id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		blogData = blogApplicationService.readBlog(blogId);
		assertThat(blogData.getTitle().equals(title)).isFalse();

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
