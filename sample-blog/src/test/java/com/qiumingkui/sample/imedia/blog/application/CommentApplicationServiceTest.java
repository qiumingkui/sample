package com.qiumingkui.sample.imedia.blog.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.imedia.blog.application.CommentApplicationService;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentData;
import com.qiumingkui.sample.imedia.blog.port.adapter.notify.NotificationMonitor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentApplicationServiceTest {

	@Autowired
	private CommentApplicationService commentApplicationService;

	private String aCommentId;
	private String aBlogId = "1";
	private String aContent = "aContent:" + new Date();

	@Before
	public void init() {
		NotificationMonitor monitor = new NotificationMonitor();
		// aCommentId = commentApplicationService.publishComment(aBlogId,
		// aContent);
		// assertThat(aCommentId.isEmpty()).isFalse();
	}

	@Test
	public void publishComment() {
		aCommentId = commentApplicationService.publishComment("2", aContent);
		assertThat(aCommentId.isEmpty()).isFalse();
		
		try {
			Thread.sleep(1000L);
		} catch (Exception e) {
			// ignore
		}
	}

	// @Test
	// public void readComment() {
	// CommentData commentData =
	// commentApplicationService.readComment(aCommentId);
	// assertThat(commentData.getContent().equals(aContent)).isTrue();
	// }
}
