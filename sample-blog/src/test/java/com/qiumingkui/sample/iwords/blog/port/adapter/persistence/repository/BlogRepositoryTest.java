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
import com.qiumingkui.sample.iwords.blog.domain.model.blog.Blog;
import com.qiumingkui.sample.iwords.blog.domain.model.blog.BlogId;
import com.qiumingkui.sample.iwords.blog.helper.BlogTestHelper;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.BlogRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {
	@Autowired
	private BlogRepository blogRepository;

	private Blog aBlog;
	private BlogId aBlogId;

	@Before
	// @Transactional
	public void save4Create() {
		aBlog = BlogTestHelper.buildBlogExample();
		aBlogId = aBlog.blogId();
		blogRepository.save(aBlog);

		Blog blog = blogRepository.get(aBlogId);
		assertThat(blog != null && blog.blogId().id().equals(aBlogId.id()));
	}

	@Test
	// @Transactional
	public void get() {
		Blog blog = blogRepository.get(aBlogId);
		assertThat(blog != null && blog.blogId().id().equals(aBlogId.id()));
	}

	@Test
	// @Transactional
	public void save4Update() {
		Title aBlogTitle = aBlog.title();
		Title title = new Title("blog" + " : this is new :" + new Date());
		Blog blog = blogRepository.get(aBlogId);
		blog.changeTitle(title);
		blogRepository.save(blog);
		blog = blogRepository.get(aBlogId);
		assertThat(blog != null && blog.title().titleTxt().equals(aBlogTitle.titleTxt())).isFalse();
	}

	@Test
	// @Transactional
	public void del() {
		blogRepository.del(aBlogId);
		Blog blog = blogRepository.get(aBlogId);
		assertThat(blog != null).isFalse();
	}

}
