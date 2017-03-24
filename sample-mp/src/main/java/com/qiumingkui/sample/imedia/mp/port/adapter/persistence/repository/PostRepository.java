package com.qiumingkui.sample.imedia.mp.port.adapter.persistence.repository;

import com.qiumingkui.sample.imedia.mp.domain.model.post.Post;
import com.qiumingkui.sample.imedia.mp.domain.model.post.PostId;

public interface PostRepository {

	public Post get(PostId aBlogId);

	public void save(Post aBlog);

	public void del(PostId aBlogId);

}
