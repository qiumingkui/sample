package com.qiumingkui.sample.imedia.mp.domain.model.post;

public interface PostRepository {

	public Post get(PostId aBlogId);

	public void save(Post aBlog);

	public void del(PostId aBlogId);

}
