package com.qiumingkui.sample.iwords.blog.domain.model.publisher.status;

import com.qiumingkui.sample.iwords.blog.domain.model.publisher.Publisher;

public class PublisherLocked extends PublisherStatus {

	
	
	public PublisherLocked() {
		super();
		this.setCode(LOCKED);
	}

	@Override
	public void lock(Publisher publisher) throws PublisherStatusException {
		String message = "当前已经锁定，不需再锁定！";
		throw new PublisherStatusException(message);				
	}

	@Override
	public void close(Publisher publisher) throws PublisherStatusException {
		String message = "当前已经关闭，不能再次锁定！";
		throw new PublisherStatusException(message);		
		
	}

	@Override
	public void reopen(Publisher publisher) throws PublisherStatusException {
		publisher.changeStatus(new PublisherOnline());	
		
	}

	

}
