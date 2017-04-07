package com.qiumingkui.sample.imedia.mp.domain.model.blogger.status;

import com.qiumingkui.sample.imedia.mp.domain.model.blogger.Blogger;

public class Online extends BloggerStatus {
	
	public Online() {
		super();
		this.setCode(ONLINE);
	}

	@Override
	public void lock(Blogger publisher) throws BloggerStatusException {
		publisher.changeStatus(new Locked());	
		
	}

	@Override
	public void close(Blogger publisher) throws BloggerStatusException {
		publisher.changeStatus(new Closed());	

		
	}

	@Override
	public void reopen(Blogger publisher) throws BloggerStatusException {
		String message = "当前已经在正常在线，不需重新打开！";
		throw new BloggerStatusException(message);	
	}

	
}
