package com.qiumingkui.sample.iwords.blog.domain.model.blogger.status;

import com.qiumingkui.sample.iwords.blog.domain.model.blogger.Blogger;

public class BloggerLocked extends BloggerStatus {

	
	
	public BloggerLocked() {
		super();
		this.setCode(LOCKED);
	}

	@Override
	public void lock(Blogger blogger) throws BloggerStatusException {
		String message = "当前已经锁定，不需再锁定！";
		throw new BloggerStatusException(message);				
	}

	@Override
	public void close(Blogger blogger) throws BloggerStatusException {
		String message = "当前已经关闭，不能再次锁定！";
		throw new BloggerStatusException(message);		
		
	}

	@Override
	public void reopen(Blogger blogger) throws BloggerStatusException {
		blogger.changeStatus(new BloggerOnline());	
		
	}

	

}
