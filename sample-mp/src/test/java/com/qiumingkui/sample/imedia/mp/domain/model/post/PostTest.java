package com.qiumingkui.sample.imedia.mp.domain.model.post;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.imedia.mp.domain.model.Content;
import com.qiumingkui.sample.imedia.mp.domain.model.Title;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostClosed;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostDraft;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostIssued;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostLocked;
import com.qiumingkui.sample.imedia.mp.domain.model.post.status.PostStatusException;
import com.qiumingkui.sample.imedia.mp.helper.PostTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostTest {

	// @Before
	// public void init() {
	//
	// }

	@Test
	public void changeTitle() {
		Post post = PostTestHelper.buildPostExample();
		Title title = new Title("Test Title:" + new Date());
		post.changeTitle(title);
		assertThat(post.title().titleTxt().equals(title.titleTxt())).isTrue();
	}

	@Test
	public void changeContend() {
		Post post = PostTestHelper.buildPostExample();
		Content content = new Content("Test Content:" + new Date());
		post.changeContent(content);
		assertThat(post.content().contentTxt().equals(content.contentTxt())).isTrue();
	}

	@Test
	public void changePostComment() {
		Post post = PostTestHelper.buildPostExample();
		PostComment postComment = new PostComment(5);
		post.changePostComment(postComment);
		assertThat(post.postComment().commentNumber() == postComment.commentNumber());
	}

	@Test
	public void issue() {
		Post post = PostTestHelper.buildPostExample();
		assertThat(post.status() instanceof PostDraft).isTrue();
		try {
			post.issue();
		} catch (PostStatusException e) {
			e.printStackTrace();
		}
		assertThat(post.status() instanceof PostIssued).isTrue();
	}
	
	@Test
	public void reopen() {
		Post post = PostTestHelper.buildPostExample();
		assertThat(post.status() instanceof PostDraft).isTrue();
		try {
			post.issue();
			post.lock();
			post.reopen();
		} catch (PostStatusException e) {
			e.printStackTrace();
		}
		assertThat(post.status() instanceof PostIssued).isTrue();
	}
	
	@Test
	public void lock() {
		Post post = PostTestHelper.buildPostExample();
		assertThat(post.status() instanceof PostDraft).isTrue();
		try {
			post.issue();
			post.lock();
		} catch (PostStatusException e) {
			e.printStackTrace();
		}
		assertThat(post.status() instanceof PostLocked).isTrue();
	}
	
	@Test
	public void close() {
		Post post = PostTestHelper.buildPostExample();
		assertThat(post.status() instanceof PostDraft).isTrue();
		try {
			post.issue();
			post.close();
		} catch (PostStatusException e) {
			e.printStackTrace();
		}
		assertThat(post.status() instanceof PostClosed).isTrue();
	}
	
	
}
