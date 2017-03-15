package com.qiumingkui.ddd.sample.blog.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.ddd.sample.blog.domain.model.CommentData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentApplicationServiceTest {

	@Autowired
	private CommentApplicationService commentApplicationService;

	@Test
	public void publishComment() {
		String aBlogId = "1";
		String aContent = "aContent:" + new Date();
		String commentId = commentApplicationService.publishComment(aBlogId, aContent);
		assertThat(commentId.isEmpty()).isFalse();
	}
	
	@Test
	public void readComment(){
		String blogId = "1";
		String content = "aContent:" + new Date();
		String commentId = commentApplicationService.publishComment(blogId, content);
		CommentData commentData = commentApplicationService.readComment(commentId);
		assertThat(commentData.getContent().equals(content)).isTrue();
	}
}
