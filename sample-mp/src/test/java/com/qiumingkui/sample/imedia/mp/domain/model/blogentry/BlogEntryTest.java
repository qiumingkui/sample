package com.qiumingkui.sample.imedia.mp.domain.model.blogentry;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.imedia.mp.domain.model.Content;
import com.qiumingkui.sample.imedia.mp.domain.model.Title;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.BlogEntry;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.BlogEntryComment;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.status.BlogEntryStatusException;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.status.Closed;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.status.Draft;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.status.Issued;
import com.qiumingkui.sample.imedia.mp.domain.model.blogentry.status.Locked;
import com.qiumingkui.sample.imedia.mp.helper.PostTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogEntryTest {

	// @Before
	// public void init() {
	//
	// }

	@Test
	public void changeTitle() {
		BlogEntry blogEntry = PostTestHelper.buildPostExample();
		Title title = new Title("Test Title:" + new Date());
		blogEntry.changeTitle(title);
		assertThat(blogEntry.title().titleTxt().equals(title.titleTxt())).isTrue();
	}

	@Test
	public void changeContend() {
		BlogEntry blogEntry = PostTestHelper.buildPostExample();
		Content content = new Content("Test Content:" + new Date());
		blogEntry.changeContent(content);
		assertThat(blogEntry.content().contentTxt().equals(content.contentTxt())).isTrue();
	}

	@Test
	public void changePostComment() {
		BlogEntry blogEntry = PostTestHelper.buildPostExample();
		BlogEntryComment blogEntryComment = new BlogEntryComment(5);
		blogEntry.changePostComment(blogEntryComment);
		assertThat(blogEntry.blogEntryComment().commentNumber() == blogEntryComment.commentNumber());
	}

	@Test
	public void issue() {
		BlogEntry blogEntry = PostTestHelper.buildPostExample();
		assertThat(blogEntry.status() instanceof Draft).isTrue();
		try {
			blogEntry.issue();
		} catch (BlogEntryStatusException e) {
			e.printStackTrace();
		}
		assertThat(blogEntry.status() instanceof Issued).isTrue();
	}
	
	@Test
	public void reopen() {
		BlogEntry blogEntry = PostTestHelper.buildPostExample();
		assertThat(blogEntry.status() instanceof Draft).isTrue();
		try {
			blogEntry.issue();
			blogEntry.lock();
			blogEntry.reopen();
		} catch (BlogEntryStatusException e) {
			e.printStackTrace();
		}
		assertThat(blogEntry.status() instanceof Issued).isTrue();
	}
	
	@Test
	public void lock() {
		BlogEntry blogEntry = PostTestHelper.buildPostExample();
		assertThat(blogEntry.status() instanceof Draft).isTrue();
		try {
			blogEntry.issue();
			blogEntry.lock();
		} catch (BlogEntryStatusException e) {
			e.printStackTrace();
		}
		assertThat(blogEntry.status() instanceof Locked).isTrue();
	}
	
	@Test
	public void close() {
		BlogEntry blogEntry = PostTestHelper.buildPostExample();
		assertThat(blogEntry.status() instanceof Draft).isTrue();
		try {
			blogEntry.issue();
			blogEntry.close();
		} catch (BlogEntryStatusException e) {
			e.printStackTrace();
		}
		assertThat(blogEntry.status() instanceof Closed).isTrue();
	}
	
	
}
