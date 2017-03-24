package com.qiumingkui.sample.imedia.mp.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.imedia.mp.application.PostApplicationService;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Author;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Reader;
import com.qiumingkui.sample.imedia.mp.domain.model.post.PostData;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostStatus;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostStatusException;
import com.qiumingkui.sample.imedia.mp.helper.MemberTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostApplicationServiceTest {

	// @Autowired
	// private PersonRepository personRepository;

	@Autowired
	private PostApplicationService postApplicationService;

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
			blogId = postApplicationService.publishBlog(title, content, MemberTestHelper.buildAuthorExample(true));
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
		Author author = MemberTestHelper.buildAuthorExample(true);
		try {
			blogId = postApplicationService.publishBlog(title, content, author);
		} catch (Exception e) {

			e.printStackTrace();
		}
		Reader reader = MemberTestHelper.buildReader(true);
		PostData postData = null;
		try {
			postData = postApplicationService.readBlog(blogId, reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(postData != null).isTrue();
		assertThat(postData.getTitle().equals(title)).isTrue();
	}

	@Test
	public void modifyBlog() {
		String blogId = null;
		Author author = MemberTestHelper.buildAuthorExample(true);
		try {
			blogId = postApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date(), author);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		String title = "aTitle modify by aPerson4CommonUser:" + new Date();
		String content = "aContent modify by aPerson4CommonUser:" + new Date();
		try {
			postApplicationService.modifyBlog(blogId, title, content, author);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Reader reader = MemberTestHelper.buildReader(true);
		PostData postData = null;
		try {
			postData = postApplicationService.readBlog(blogId, reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(postData != null).isTrue();
		assertThat(postData.getTitle().equals(title)).isTrue();

	}

	@Test
	public void lockBlog() {
		String blogId = null;
		try {
			blogId = postApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date(),
					MemberTestHelper.buildAuthorExample(true));
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			postApplicationService.lockBlog(blogId);
		} catch (PostStatusException e) {
			e.printStackTrace();
		}
		Reader reader = MemberTestHelper.buildReader(true);
		PostData postData = null;
		try {
			postData = postApplicationService.readBlog(blogId, reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(postData != null).isTrue();
		assertThat(postData.getStatus() == PostStatus.CLOSED).isFalse();
		assertThat(postData.getStatus() == PostStatus.LOCKED).isTrue();
	}

	@Test
	public void closeBlog() {
		String blogId = null;
		try {
			blogId = postApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date(),
					MemberTestHelper.buildAuthorExample(true));
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			postApplicationService.closeBlog(blogId);
		} catch (PostStatusException e) {
			e.printStackTrace();
		}
		Reader reader = MemberTestHelper.buildReader(true);
		PostData postData = null;
		try {
			postData = postApplicationService.readBlog(blogId, reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(postData != null).isFalse();
		// assertThat(blogData.getStatus() == BlogStatus.CLOSED).isTrue();
		// assertThat(blogData.getStatus() == BlogStatus.LOCKED).isFalse();
	}

	@Test
	public void reopenBlog() {
		String blogId = null;
		try {
			blogId = postApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date(),
					MemberTestHelper.buildAuthorExample(true));
			postApplicationService.closeBlog(blogId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		Reader reader = MemberTestHelper.buildReader(true);
		PostData postData = null;
		try {
			postData = postApplicationService.readBlog(blogId, reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(postData != null).isFalse();
		// assertThat(blogData.getStatus() == BlogStatus.CLOSED).isTrue();

		try {
			postApplicationService.reopenBlog(blogId);
		} catch (PostStatusException e) {
			e.printStackTrace();
		}

		reader = MemberTestHelper.buildReader(true);
		try {
			postData = postApplicationService.readBlog(blogId, reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(postData != null).isTrue();
		assertThat(postData.getStatus() == PostStatus.ISSUED).isTrue();
	}

}
