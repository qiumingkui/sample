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

import com.qiumingkui.sample.iwords.blog.domain.model.Comment;
import com.qiumingkui.sample.iwords.blog.domain.model.CommentId;
import com.qiumingkui.sample.iwords.blog.domain.model.Content;
import com.qiumingkui.sample.iwords.blog.helper.CommentTestHelper;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.CommentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRepositoryTest {

	@Autowired
	private CommentRepository commentRepository;

	private Comment aComment;
	private CommentId aCommentId;

	@Before
	// @Transactional
	public void sava4Create() {
		aComment = CommentTestHelper.buildCommentExample();
		aCommentId = aComment.commentId();
		commentRepository.save(aComment);

		Comment comment = commentRepository.get(aCommentId);
		assertThat(comment != null && comment.commentId().id().equals(aCommentId.id())).isTrue();
	}

	@Test
	// @Transactional
	public void get() {
		Comment comment = commentRepository.get(aCommentId);
		assertThat(comment != null && comment.commentId().id().equals(aCommentId.id())).isTrue();
	}

	@Test
	// @Transactional
	public void save4Update() {
		Comment comment = commentRepository.get(aComment.commentId());
		Content content = comment.content();

		Content newContent = new Content("comment" + " : this is new :" + new Date());
		comment.changeContent(newContent);
		commentRepository.save(comment);

		assertThat(comment.content().contentTxt().equals(content.contentTxt())).isFalse();
	}

	@Test
	// @Transactional
	public void del() {
		commentRepository.del(aCommentId);
		Comment component = commentRepository.get(aCommentId);
		assertThat(component == null).isTrue();
	}

}
