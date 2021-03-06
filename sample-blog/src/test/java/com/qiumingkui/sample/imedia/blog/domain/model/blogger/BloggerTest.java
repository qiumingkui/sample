package com.qiumingkui.sample.imedia.blog.domain.model.blogger;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.imedia.blog.domain.model.blogger.Blogger;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.BloggerBlogEntryVal;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.rank.BloggerRank;
import com.qiumingkui.sample.imedia.blog.helper.BloggerTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BloggerTest {

	@Test
	public void changeBloggerPost() {
		Blogger blogger = BloggerTestHelper.buildBloggerExample();
		blogger.changeBlogEntryVal(new BloggerBlogEntryVal(1, 1));
		assertTrue(blogger.blogEntryVal().postNumber() == 1);
		assertTrue(blogger.blogEntryVal().commentNumber() == 1);
	}

	@Test
	public void changeRank() {
		Blogger blogger = BloggerTestHelper.buildBloggerExample();
		blogger.changeRank(BloggerRank.MASTER);
		assertTrue(blogger.rank()==BloggerRank.MASTER);
	}
}
