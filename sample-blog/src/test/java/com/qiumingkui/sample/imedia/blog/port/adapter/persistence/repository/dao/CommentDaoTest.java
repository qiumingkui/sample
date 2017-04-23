package com.qiumingkui.sample.imedia.blog.port.adapter.persistence.repository.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.imedia.blog.domain.model.Content;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.Comment;
import com.qiumingkui.sample.imedia.blog.domain.model.comment.CommentId;
import com.qiumingkui.sample.imedia.blog.helper.CommentTestHelper;
import com.qiumingkui.sample.imedia.blog.port.adapter.persistence.dao.CommentDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDaoTest {

	private static final Logger log = LoggerFactory.getLogger(CommentDaoTest.class);

	@Autowired
	protected CommentDao commentDao;

	@Test
	@Transactional
	public void testCreate() {
		Comment comment = CommentTestHelper.buildCommentExample();
		commentDao.create(comment);

		log.info("testCreate() commentId:" + comment.id().key() + ",content:" + comment.content().contentTxt());
	}

	@Test
	@Transactional
	public void testUpdate() {
		Comment comment = CommentTestHelper.buildCommentExample();
		commentDao.create(comment);

		CommentId commentId = comment.id();
		comment = commentDao.retrieve(commentId);
		Content oldContent = comment.content();

		Content content = new Content("comment" + " : this is new :" + new Date());
		comment.changeContent(content);
		commentDao.update(comment);

		log.info("testUpdate() commentId:" + comment.id().key() + ",old content:" + oldContent.contentTxt()
				+ ",new content:" + comment.content().contentTxt());
	}

	@Test
	@Transactional
	public void testRetrieve() {
		Comment comment = CommentTestHelper.buildCommentExample();
		commentDao.create(comment);

		CommentId commentId = comment.id();
		comment = commentDao.retrieve(commentId);

		log.info("testRetrieve() commentId:" + comment.id().key() + ",content:" + comment.content().contentTxt());
	}

	@Test
	@Transactional
	public void testDelete() {
		Comment comment = CommentTestHelper.buildCommentExample();
		commentDao.create(comment);

		CommentId commentId = comment.id();
		commentDao.delete(commentId);

		log.info("testDelete() commentId:" + commentId.key());
	}

}
