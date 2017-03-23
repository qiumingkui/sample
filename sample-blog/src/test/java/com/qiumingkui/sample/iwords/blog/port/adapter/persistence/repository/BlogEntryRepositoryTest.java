package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.iwords.blog.domain.model.Title;
import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntry;
import com.qiumingkui.sample.iwords.blog.domain.model.blogentry.BlogEntryId;
import com.qiumingkui.sample.iwords.blog.helper.BlogEntryTestHelper;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.BlogEntryRepository;

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
		aBlog = BlogEntryTestHelper.buildBlogExample();
		aBlogId = aBlog.blogEntryId();
		blogEntryRepository.save(aBlog);

		BlogEntry blogEntry = blogEntryRepository.get(aBlogId);
		assertThat(blogEntry != null && blogEntry.blogEntryId().id().equals(aBlogId.id()));
	}

	@Test
	// @Transactional
	public void get() {
		BlogEntry blogEntry = blogEntryRepository.get(aBlogId);
		assertThat(blogEntry != null && blogEntry.blogEntryId().id().equals(aBlogId.id()));
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
