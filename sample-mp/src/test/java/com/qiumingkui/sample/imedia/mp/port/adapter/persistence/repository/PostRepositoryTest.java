package com.qiumingkui.sample.imedia.mp.port.adapter.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;

import com.qiumingkui.sample.imedia.mp.domain.model.Title;
import com.qiumingkui.sample.imedia.mp.domain.model.post.Post;
import com.qiumingkui.sample.imedia.mp.domain.model.post.PostId;
import com.qiumingkui.sample.imedia.mp.domain.model.post.PostRepository;
import com.qiumingkui.sample.imedia.mp.helper.PostTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
	@Autowired
	private PostRepository postRepository;

	private Post aBlog;
	private PostId aBlogId;

	@Before
	// @Transactional
	public void save4Create() {
		aBlog = PostTestHelper.buildPostExample();
		aBlogId = aBlog.postId();
		postRepository.save(aBlog);

		Post post = postRepository.get(aBlogId);
		assertThat(post != null && post.postId().id().equals(aBlogId.id()));
	}

	@Test
	// @Transactional
	public void get() {
		Post post = postRepository.get(aBlogId);
		assertThat(post != null && post.postId().id().equals(aBlogId.id()));
	}

	@Test
	// @Transactional
	public void save4Update() {
		Title aBlogTitle = aBlog.title();
		Title title = new Title("blog" + " : this is new :" + new Date());
		Post post = postRepository.get(aBlogId);
		post.changeTitle(title);
		postRepository.save(post);
		post = postRepository.get(aBlogId);
		assertThat(post != null && post.title().titleTxt().equals(aBlogTitle.titleTxt())).isFalse();
	}

	@Test
	// @Transactional
	public void del() {
		postRepository.del(aBlogId);
		Post post = postRepository.get(aBlogId);
		assertThat(post != null).isFalse();
	}

}
