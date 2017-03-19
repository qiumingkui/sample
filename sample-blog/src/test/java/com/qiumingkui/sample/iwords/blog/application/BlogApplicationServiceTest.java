package com.qiumingkui.sample.iwords.blog.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.iwords.blog.application.BlogApplicationService;
import com.qiumingkui.sample.iwords.blog.domain.model.BlogData;
import com.qiumingkui.sample.iwords.blog.domain.model.BlogStatus;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Author;
import com.qiumingkui.sample.iwords.blog.helper.MemberTestHelper;
//import com.qiumingkui.sample.iwords.user.domain.model.Person;
//import com.qiumingkui.sample.iwords.user.port.adapter.persistence.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationServiceTest {

//	@Autowired
//	private PersonRepository personRepository;

	@Autowired
	private BlogApplicationService blogApplicationService;

//	private Person aPerson4Admin;
//	private Person aPerson4CommonUser;
//	private Person aAnonymous;

	@Before
	public void init() {
//		aPerson4Admin = MemberTestHelper.buildPerson4AdminExample();
//		aPerson4CommonUser = MemberTestHelper.buildPerson4CommonUserExample();
//		aAnonymous = MemberTestHelper.buildPerson4AnonymousExample();
//		personRepository.save(aPerson4Admin);
//		personRepository.save(aPerson4CommonUser);
//		personRepository.save(aAnonymous);

	}

	@Test
	public void publishBlog() {
		String title = "aTitle:" + new Date();
		String content = "aContent:" + new Date();
		String blogId = null;
		try {
			blogId = blogApplicationService.publishBlog(title, content, MemberTestHelper.buildAuthorExample(true));
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
		try {
			blogId = blogApplicationService.publishBlog(title, content, MemberTestHelper.buildAuthorExample(true));
		} catch (Exception e) {

			e.printStackTrace();
		}
		BlogData blogData = blogApplicationService.readBlog(blogId);
		assertThat(blogData.getTitle().equals(title)).isTrue();
	}

	@Test
	public void modifyBlog() {
		String blogId = null;
		Author author= MemberTestHelper.buildAuthorExample(true);
		try {
			blogId = blogApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date(),
					author);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		String title = "aTitle modify by aPerson4CommonUser:" + new Date();
		String content = "aContent modify by aPerson4CommonUser:" + new Date();
		try {
			blogApplicationService.modifyBlog(blogId, title, content, author);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BlogData blogData = blogApplicationService.readBlog(blogId);
		assertThat(blogData.getTitle().equals(title)).isTrue();

		// title = "aTitle modify by aPerson4Admin:" + new Date();
		// content = "aContent modify by aPerson4Admin:" + new Date();
		// try {
		// blogApplicationService.modifyBlog(blogId, title, content,
		// aPerson4Admin.personId().id());
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// blogData = blogApplicationService.readBlog(blogId);
		// assertThat(blogData.getTitle().equals(title)).isFalse();
		//
		// title = "aTitle modify by anonymous:" + new Date();
		// content = "aContent modify by anonymous:" + new Date();
		// try {
		// blogApplicationService.modifyBlog(blogId, title, content,
		// aAnonymous.personId().id());
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// blogData = blogApplicationService.readBlog(blogId);
		// assertThat(blogData.getTitle().equals(title)).isFalse();

	}

	@Test
	public void lockBlog() {
		String blogId = null;
		try {
			blogId = blogApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date(),
					MemberTestHelper.buildAuthorExample(true));
		} catch (Exception e) {

			e.printStackTrace();
		}
		blogApplicationService.lockBlog(blogId);
		BlogData blogData = blogApplicationService.readBlog(blogId);
		assertThat(blogData.getStatus() == BlogStatus.CLOSE).isFalse();
		assertThat(blogData.getStatus() == BlogStatus.LOCK).isTrue();
	}

	@Test
	public void closeBlog() {
		String blogId = null;
		try {
			blogId = blogApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date(),
					MemberTestHelper.buildAuthorExample(true));
		} catch (Exception e) {

			e.printStackTrace();
		}
		blogApplicationService.closeBlog(blogId);
		BlogData blogData = blogApplicationService.readBlog(blogId);
		assertThat(blogData.getStatus() == BlogStatus.CLOSE).isTrue();
		assertThat(blogData.getStatus() == BlogStatus.LOCK).isFalse();
	}

	@Test
	public void reopenBlog() {
		String blogId = null;
		try {
			blogId = blogApplicationService.publishBlog("aTitle:" + new Date(), "aContent:" + new Date(),
					MemberTestHelper.buildAuthorExample(true));
		} catch (Exception e) {

			e.printStackTrace();
		}
		blogApplicationService.reopenBlog(blogId);
		BlogData blogData = blogApplicationService.readBlog(blogId);
		assertThat(blogData.getStatus() == BlogStatus.REOPEN).isTrue();
		assertThat(blogData.getStatus() == BlogStatus.ISSUE).isFalse();
	}

}
