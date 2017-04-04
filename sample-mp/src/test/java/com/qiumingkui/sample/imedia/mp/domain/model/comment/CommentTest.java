package com.qiumingkui.sample.imedia.mp.domain.model.comment;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.imedia.mp.domain.model.Content;
import com.qiumingkui.sample.imedia.mp.domain.model.comment.Comment;
import com.qiumingkui.sample.imedia.mp.helper.CommentTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTest {

	@Test
	public void changeContent() {
		Comment comment = CommentTestHelper.buildCommentExample();
		Content content = new Content("Test Content:"+new Date());
		comment.changeContent(content);
		assertThat(comment.content().contentTxt().equals(content.contentTxt())).isTrue();
	}

}
