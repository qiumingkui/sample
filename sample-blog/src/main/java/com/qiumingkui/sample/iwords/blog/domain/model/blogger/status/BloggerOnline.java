package com.qiumingkui.sample.iwords.blog.domain.model.blogger.status;

import com.qiumingkui.sample.iwords.blog.domain.model.blogger.Blogger;

public class BloggerOnline extends BloggerStatus {
	
	public BloggerOnline() {
		super();
		this.setCode(ONLINE);
	}

	@Override
	public void lock(Blogger blogger) throws BloggerStatusException {
		blogger.changeStatus(new BloggerLocked());	
		
	}

	@Override
	public void close(Blogger blogger) throws BloggerStatusException {
		blogger.changeStatus(new BloggerClosed());	

		
	}

	@Override
	public void reopen(Blogger blogger) throws BloggerStatusException {
		String message = "当前已经在正常在线，不需重新打开！";
		throw new BloggerStatusException(message);	
	}

	
}
