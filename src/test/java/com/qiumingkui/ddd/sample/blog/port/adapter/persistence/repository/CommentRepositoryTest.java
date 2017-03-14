package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.repository;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.ddd.sample.blog.domain.model.Comment;
import com.qiumingkui.ddd.sample.blog.domain.model.CommentId;
import com.qiumingkui.ddd.sample.blog.domain.model.CommentTestHelper;
import com.qiumingkui.ddd.sample.blog.domain.model.Content;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(CommentRepositoryTest.class);

	@Autowired
	private CommentRepository commentRepository;

	@Test
	public void testGenId() {
		log.info("testGenId() genId:" + commentRepository.genId().id());
	}

	@Test
	@Transactional
	public void testGet() {
		Comment comment = CommentTestHelper.buildCommentExample();
		commentRepository.save(comment);

		comment = commentRepository.get(comment.commentId());
		log.info("testGet() content:" + comment.content().contentTxt());
	}

	@Test
	@Transactional
	// @Commit
	public void testSave() {
		Comment comment = CommentTestHelper.buildCommentExample();
		commentRepository.save(comment);

		comment = commentRepository.get(comment.commentId());
		Content content = comment.content();

		Content newContent = new Content("comment" + " : this is new :" + new Date());
		comment.changeContent(newContent);
		commentRepository.save(comment);

		log.info("testSave() " + " old content:" + content.contentTxt() + "new content:"
				+ comment.content().contentTxt());
	}

	@Test
	@Transactional
	public void testDel() {
		Comment comment = CommentTestHelper.buildCommentExample();
		commentRepository.save(comment);

		CommentId commentId = comment.commentId();
		commentRepository.del(commentId);

		log.info("testDelete() blogId:" + commentId.id());
	}

}
