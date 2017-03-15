package com.qiumingkui.ddd.sample.blog.port.adapter.persistence.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.ddd.sample.blog.domain.model.Comment;
import com.qiumingkui.ddd.sample.blog.domain.model.CommentId;
import com.qiumingkui.ddd.sample.blog.domain.model.CommentBuilder;
import com.qiumingkui.ddd.sample.blog.domain.model.Content;
import com.qiumingkui.ddd.sample.common.util.UUIDUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDaoTest {

	private static final Logger log = LoggerFactory.getLogger(CommentDaoTest.class);

	@Autowired
	protected CommentDao commentDao;


	@Test
	@Transactional
	public void testCreate() {
		Comment comment = buildCommentExample();
		commentDao.create(comment);
		
		log.info("testCreate() commentId:" + comment.commentId().id() + ",content:" + comment.content().contentTxt());
	}

	@Test
	@Transactional
	public void testUpdate() {
		Comment comment = buildCommentExample();
		commentDao.create(comment);
	
		CommentId commentId = comment.commentId();
		comment = commentDao.retrieve(commentId);
		Content oldContent= comment.content();
		
		Content content = new Content("comment" + " : this is new :" + new Date());
		comment.changeContent(content);
		commentDao.update(comment);
		
		log.info("testUpdate() commentId:" + comment.commentId().id() + ",old content:"+oldContent.contentTxt()+",new content:" + comment.content().contentTxt());
	}

	@Test
	@Transactional
	public void testRetrieve() {
		Comment comment = buildCommentExample();
		commentDao.create(comment);

		CommentId commentId = comment.commentId();
		comment = commentDao.retrieve(commentId);
		
		log.info("testRetrieve() commentId:" + comment.commentId().id() + ",content:" + comment.content().contentTxt());
	}

	@Test
	@Transactional
	public void testDelete() {
		Comment comment = buildCommentExample();
		commentDao.create(comment);
		
		CommentId commentId = comment.commentId();
		commentDao.delete(commentId);
		
		log.info("testDelete() commentId:" + commentId.id());
	}

	private Comment buildCommentExample() {
		return CommentBuilder.build("1","content" + " : " + new Date());
	}

}
