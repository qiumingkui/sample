package com.qiumingkui.sample.imedia.blog.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.imedia.blog.application.BlogEntryApplicationService;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryData;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryStatusException;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogAuthor;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogReader;
import com.qiumingkui.sample.imedia.blog.helper.MemberTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogEntryApplicationServiceTest {

	// @Autowired
	// private PersonRepository personRepository;

	@Autowired
	private BlogEntryApplicationService blogEntryApplicationService;

	// private Person aPerson4Admin;
	// private Person aPerson4CommonUser;
	// private Person aAnonymous;

	@Before
	public void init() {
		// aPerson4Admin = MemberTestHelper.buildPerson4AdminExample();
		// aPerson4CommonUser =
		// MemberTestHelper.buildPerson4CommonUserExample();
		// aAnonymous = MemberTestHelper.buildPerson4AnonymousExample();
		// personRepository.save(aPerson4Admin);
		// personRepository.save(aPerson4CommonUser);
		// personRepository.save(aAnonymous);

	}

	@Test
	public void publishBlog() {
		String title = "aTitle:" + new Date();
		String content = "aContent:" + new Date();
		String blogId = null;
		try {
			blogId = blogEntryApplicationService.publishBlog(title, content, MemberTestHelper.buildAuthorExample(true));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(blogId.isEmpty()).isFalse();
	}

	@Test
	public void readBlog() {
		String title = "aTitle:" + new Date();
		String content = "aContent:" + new Date();
		String blogId = null;
		BlogAuthor blogAuthor = MemberTestHelper.buildAuthorExample(true);
		try {
			blogId = blogEntryApplicationService.publishBlog(title, content, blogAuthor);
		} catch (Exception e) {

			e.printStackTrace();
		}
		BlogReader blogReader = MemberTestHelper.buildReader(true);
		BlogEntryData blogEntryData = null;
		try {
			blogEntryData = blogEntryApplicationService.readBlog(blogId, blogReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(blogEntryData != null).isTrue();
		assertThat(blogEntryData.getTitle().equals(title)).isTrue();
	}

	@Test
	public void modifyBlog() {
		String blogId = null;
		BlogAuthor blogAuthor = MemberTestHelper.buildAuthorExample(true);
		try {
			blogId = blogEntryApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date(), blogAuthor);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		String title = "aTitle modify by aPerson4CommonUser:" + new Date();
		String content = "aContent modify by aPerson4CommonUser:" + new Date();
		try {
			blogEntryApplicationService.modifyBlog(blogId, title, content, blogAuthor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BlogReader blogReader = MemberTestHelper.buildReader(true);
		BlogEntryData blogEntryData = null;
		try {
			blogEntryData = blogEntryApplicationService.readBlog(blogId, blogReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(blogEntryData != null).isTrue();
		assertThat(blogEntryData.getTitle().equals(title)).isTrue();

	}

	@Test
	public void lockBlog() {
		String blogId = null;
		try {
			blogId = blogEntryApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date(),
					MemberTestHelper.buildAuthorExample(true));
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			blogEntryApplicationService.lockBlog(blogId);
		} catch (BlogEntryStatusException e) {
			e.printStackTrace();
		}
		BlogReader blogReader = MemberTestHelper.buildReader(true);
		BlogEntryData blogEntryData = null;
		try {
			blogEntryData = blogEntryApplicationService.readBlog(blogId, blogReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(blogEntryData != null).isTrue();
		assertThat(blogEntryData.getStatus() == BlogEntryStatus.CLOSED).isFalse();
		assertThat(blogEntryData.getStatus() == BlogEntryStatus.LOCKED).isTrue();
	}

	@Test
	public void closeBlog() {
		String blogId = null;
		try {
			blogId = blogEntryApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date(),
					MemberTestHelper.buildAuthorExample(true));
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			blogEntryApplicationService.closeBlog(blogId);
		} catch (BlogEntryStatusException e) {
			e.printStackTrace();
		}
		BlogReader blogReader = MemberTestHelper.buildReader(true);
		BlogEntryData blogEntryData = null;
		try {
			blogEntryData = blogEntryApplicationService.readBlog(blogId, blogReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(blogEntryData != null).isFalse();
		// assertThat(blogData.getStatus() == BlogStatus.CLOSED).isTrue();
		// assertThat(blogData.getStatus() == BlogStatus.LOCKED).isFalse();
	}

	@Test
	public void reopenBlog() {
		String blogId = null;
		try {
			blogId = blogEntryApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date(),
					MemberTestHelper.buildAuthorExample(true));
			blogEntryApplicationService.closeBlog(blogId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		BlogReader blogReader = MemberTestHelper.buildReader(true);
		BlogEntryData blogEntryData = null;
		try {
			blogEntryData = blogEntryApplicationService.readBlog(blogId, blogReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(blogEntryData != null).isFalse();
		// assertThat(blogData.getStatus() == BlogStatus.CLOSED).isTrue();

		try {
			blogEntryApplicationService.reopenBlog(blogId);
		} catch (BlogEntryStatusException e) {
			e.printStackTrace();
		}

		blogReader = MemberTestHelper.buildReader(true);
		try {
			blogEntryData = blogEntryApplicationService.readBlog(blogId, blogReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(blogEntryData != null).isTrue();
		assertThat(blogEntryData.getStatus() == BlogEntryStatus.ISSUED).isTrue();
	}

}
