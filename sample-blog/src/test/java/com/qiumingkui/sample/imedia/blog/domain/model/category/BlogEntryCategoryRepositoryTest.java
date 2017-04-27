package com.qiumingkui.sample.imedia.blog.domain.model.category;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.imedia.blog.helper.BlogEntryCategoryTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogEntryCategoryRepositoryTest {

	@Autowired
	private BlogEntryCategoryRepository blogEntryCategoryRepository;

	private BlogEntryCategory blogEntryCategory;
	private BlogEntryCategoryId blogEntryCategoryId;

	@Before
	// @Transactional
	public void sava4Create() {
		blogEntryCategory = BlogEntryCategoryTestHelper.buildBlogEntryCategoryExample();
		blogEntryCategoryId = blogEntryCategory.id();
		blogEntryCategoryRepository.save(blogEntryCategory);

		BlogEntryCategory be = blogEntryCategoryRepository.get(blogEntryCategoryId);
		assertThat(be != null).isTrue();
	}

	@Test
	// @Transactional
	public void get() {
		BlogEntryCategory be = blogEntryCategoryRepository.get(blogEntryCategoryId);
		assertThat(be != null).isTrue();
	}

	@Test
	// @Transactional
	public void del() {
		blogEntryCategoryRepository.del(blogEntryCategoryId);
		BlogEntryCategory be = blogEntryCategoryRepository.get(blogEntryCategoryId);
		assertThat(be == null).isTrue();
	}

}
