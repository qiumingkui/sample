package com.qiumingkui.sample.imedia.mp.domain.model.publisher.status;

import com.qiumingkui.sample.imedia.mp.domain.model.publisher.Blogger;

public class Locked extends BloggerStatus {

	
	
	public Locked() {
		super();
		this.setCode(LOCKED);
	}

	@Override
	public void lock(Blogger publisher) throws BloggerStatusException {
		String message = "当前已经锁定，不需再锁定！";
		throw new BloggerStatusException(message);				
	}

	@Override
	public void close(Blogger publisher) throws BloggerStatusException {
		String message = "当前已经关闭，不能再次锁定！";
		throw new BloggerStatusException(message);		
		
	}

	@Override
	public void reopen(Blogger publisher) throws BloggerStatusException {
		publisher.changeStatus(new Online());	
		
	}

	

}
