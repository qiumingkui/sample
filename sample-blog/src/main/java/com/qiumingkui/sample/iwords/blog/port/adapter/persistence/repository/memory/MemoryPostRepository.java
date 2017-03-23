package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.memory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.qiumingkui.sample.iwords.blog.domain.model.post.Post;
import com.qiumingkui.sample.iwords.blog.domain.model.post.PostId;
import com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository.PostRepository;

@Service
public class MemoryPostRepository implements PostRepository {

	private static Map<String, Post> cache = new HashMap<String, Post>();

	@Override
	public Post get(PostId aBlogId) {
		return cache.get(aBlogId.id());
	}

	@Override
	public void save(Post aBlog) {
		cache.put(aBlog.postId().id(), aBlog);

	}

	@Override
	public void del(PostId aBlogId) {
		cache.remove(aBlogId.id());
	}

}
