package com.qiumingkui.sample.imedia.blog.domain.model.blogentry;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.imedia.blog.domain.model.Title;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntry;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryId;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryRepository;
import com.qiumingkui.sample.imedia.blog.helper.BlogEntryTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogEntryRepositoryTest {
	@Autowired
	private BlogEntryRepository blogEntryRepository;

	private BlogEntry aBlog;
	private BlogEntryId aBlogId;

	@Before
	// @Transactional
	public void save4Create() {
		aBlog = BlogEntryTestHelper.buildBlogEntryExample();
		aBlogId = aBlog.id();
		blogEntryRepository.save(aBlog);

		BlogEntry blogEntry = blogEntryRepository.get(aBlogId);
		assertThat(blogEntry != null && blogEntry.id().key().equals(aBlogId.key()));
	}

	@Test
	// @Transactional
	public void get() {
		BlogEntry blogEntry = blogEntryRepository.get(aBlogId);
		assertThat(blogEntry != null && blogEntry.id().key().equals(aBlogId.key()));
	}

	@Test
	// @Transactional
	public void save4Update() {
		Title aBlogTitle = aBlog.title();
		Title title = new Title("blog" + " : this is new :" + new Date());
		BlogEntry blogEntry = blogEntryRepository.get(aBlogId);
		blogEntry.changeTitle(title);
		blogEntryRepository.save(blogEntry);
		blogEntry = blogEntryRepository.get(aBlogId);
		assertThat(blogEntry != null && blogEntry.title().titleTxt().equals(aBlogTitle.titleTxt())).isFalse();
	}

	@Test
	// @Transactional
	public void del() {
		blogEntryRepository.del(aBlogId);
		BlogEntry blogEntry = blogEntryRepository.get(aBlogId);
		assertThat(blogEntry != null).isFalse();
	}

}
