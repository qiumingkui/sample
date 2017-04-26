package com.qiumingkui.sample.imedia.blog.domain.model.blogger;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.imedia.blog.domain.model.blogger.Blogger;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.BloggerId;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.BloggerPost;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.BloggerRepository;
import com.qiumingkui.sample.imedia.blog.helper.BloggerTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BloggerRepositoryTest {
	@Autowired
	private BloggerRepository bloggerRepository;

	private Blogger aBlog;
	private BloggerId aBlogId;

	@Before
	// @Transactional
	public void save4Create() {
		aBlog = BloggerTestHelper.buildBloggerExample();
		aBlogId = aBlog.id();
		bloggerRepository.save(aBlog);

		Blogger blogger = bloggerRepository.get(aBlogId);
		assertThat(blogger != null && blogger.id().key().equals(aBlogId.key()));
	}

	@Test
	// @Transactional
	public void get() {
		Blogger blogger = bloggerRepository.get(aBlogId);
		assertThat(blogger != null && blogger.id().key().equals(aBlogId.key()));
	}

	@Test
	// @Transactional
	public void save4Update() {
		BloggerPost bloggerPost = aBlog.bloggerPost();
		BloggerPost modifyBloggerPost=new BloggerPost(bloggerPost.postNumber()+1, bloggerPost.commentNumber()+1);
		Blogger blogger = bloggerRepository.get(aBlogId);
		blogger.changeBloggerPost(modifyBloggerPost);
		bloggerRepository.save(blogger);
		blogger = bloggerRepository.get(aBlogId);
		assertThat(blogger != null && blogger.bloggerPost().postNumber()==modifyBloggerPost.postNumber()).isTrue();
	}

	@Test
	// @Transactional
	public void del() {
		bloggerRepository.del(aBlogId);
		Blogger blogger = bloggerRepository.get(aBlogId);
		assertThat(blogger != null).isFalse();
	}

}
