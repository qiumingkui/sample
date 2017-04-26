package com.qiumingkui.sample.imedia.blog.domain.model.blogger;

public interface BloggerRepository {

	public Blogger get(BloggerId aBloggerId);

	public void save(Blogger aBlogger);

	public void del(BloggerId aBloggerId);

}
