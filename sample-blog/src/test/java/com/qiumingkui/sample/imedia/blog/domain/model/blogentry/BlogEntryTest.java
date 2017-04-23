package com.qiumingkui.sample.imedia.blog.domain.model.blogentry;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.imedia.blog.domain.model.Content;
import com.qiumingkui.sample.imedia.blog.domain.model.Title;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntry;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.BlogEntryComment;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryStatusException;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryClosedStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryDraftStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryIssuedStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogentry.status.BlogEntryLockedStatus;
import com.qiumingkui.sample.imedia.blog.helper.BlogEntryTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogEntryTest {

	// @Before
	// public void init() {
	//
	// }

	@Test
	public void changeTitle() {
		BlogEntry blogEntry = BlogEntryTestHelper.buildBlogEntryExample();
		Title title = new Title("Test Title:" + new Date());
		blogEntry.changeTitle(title);
		assertThat(blogEntry.title().titleTxt().equals(title.titleTxt())).isTrue();
	}

	@Test
	public void changeContend() {
		BlogEntry blogEntry = BlogEntryTestHelper.buildBlogEntryExample();
		Content content = new Content("Test Content:" + new Date());
		blogEntry.changeContent(content);
		assertThat(blogEntry.content().contentTxt().equals(content.contentTxt())).isTrue();
	}

	@Test
	public void changePostComment() {
		BlogEntry blogEntry = BlogEntryTestHelper.buildBlogEntryExample();
		BlogEntryComment blogEntryComment = new BlogEntryComment(5);
		blogEntry.changePostComment(blogEntryComment);
		assertThat(blogEntry.blogEntryComment().commentNumber() == blogEntryComment.commentNumber());
	}

	@Test
	public void issue() {
		BlogEntry blogEntry = BlogEntryTestHelper.buildBlogEntryExample();
		assertThat(blogEntry.status() instanceof BlogEntryDraftStatus).isTrue();
		try {
			blogEntry.issue();
		} catch (BlogEntryStatusException e) {
			e.printStackTrace();
		}
		assertThat(blogEntry.status() instanceof BlogEntryIssuedStatus).isTrue();
	}
	
	@Test
	public void reopen() {
		BlogEntry blogEntry = BlogEntryTestHelper.buildBlogEntryExample();
		assertThat(blogEntry.status() instanceof BlogEntryDraftStatus).isTrue();
		try {
			blogEntry.issue();
			blogEntry.lock();
			blogEntry.reopen();
		} catch (BlogEntryStatusException e) {
			e.printStackTrace();
		}
		assertThat(blogEntry.status() instanceof BlogEntryIssuedStatus).isTrue();
	}
	
	@Test
	public void lock() {
		BlogEntry blogEntry = BlogEntryTestHelper.buildBlogEntryExample();
		assertThat(blogEntry.status() instanceof BlogEntryDraftStatus).isTrue();
		try {
			blogEntry.issue();
			blogEntry.lock();
		} catch (BlogEntryStatusException e) {
			e.printStackTrace();
		}
		assertThat(blogEntry.status() instanceof BlogEntryLockedStatus).isTrue();
	}
	
	@Test
	public void close() {
		BlogEntry blogEntry = BlogEntryTestHelper.buildBlogEntryExample();
		assertThat(blogEntry.status() instanceof BlogEntryDraftStatus).isTrue();
		try {
			blogEntry.issue();
			blogEntry.close();
		} catch (BlogEntryStatusException e) {
			e.printStackTrace();
		}
		assertThat(blogEntry.status() instanceof BlogEntryClosedStatus).isTrue();
	}
	
	
}
