package com.qiumingkui.sample.iwords.blog.port.adapter.persistence.repository;

import com.qiumingkui.sample.iwords.blog.domain.model.post.Post;
import com.qiumingkui.sample.iwords.blog.domain.model.post.PostId;

public interface PostRepository {

	public Post get(PostId aBlogId);

	public void save(Post aBlog);

	public void del(PostId aBlogId);

}
