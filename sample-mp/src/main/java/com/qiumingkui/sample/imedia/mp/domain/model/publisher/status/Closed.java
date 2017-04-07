package com.qiumingkui.sample.imedia.mp.domain.model.publisher.status;

import com.qiumingkui.sample.imedia.mp.domain.model.publisher.Blogger;

public class Closed extends BloggerStatus {
	
	

	public Closed() {
		super();
		this.setCode(CLOSED);
	}

	@Override
	public void lock(Blogger publisher) throws BloggerStatusException {
		String message = "当前已经关闭，不需再锁定！";
		throw new BloggerStatusException(message);		
	}

	@Override
	public void close(Blogger publisher) throws BloggerStatusException {
		String message = "当前已经关闭，不需再次关闭！";
		throw new BloggerStatusException(message);		
		
	}

	@Override
	public void reopen(Blogger publisher) throws BloggerStatusException {
		publisher.changeStatus(new Online());	
		
	}

	
	

}
