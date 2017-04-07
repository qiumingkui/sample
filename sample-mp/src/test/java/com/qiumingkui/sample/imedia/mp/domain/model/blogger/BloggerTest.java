package com.qiumingkui.sample.imedia.mp.domain.model.blogger;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.imedia.mp.domain.model.blogger.Blogger;
import com.qiumingkui.sample.imedia.mp.domain.model.blogger.BloggerPost;
import com.qiumingkui.sample.imedia.mp.helper.BloggerTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BloggerTest {

	@Test
	public void changeBloggerPost() {
		Blogger blogger = BloggerTestHelper.buildBloggerExample();
		blogger.changeBloggerPost(new BloggerPost(1, 1));
		assertTrue(blogger.bloggerPost().postNumber()==1);
		assertTrue(blogger.bloggerPost().commentNumber()==1);
	}
}
