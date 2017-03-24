package com.qiumingkui.sample.imedia.mp.domain.model.publisher.status;

import com.qiumingkui.sample.imedia.mp.domain.model.publisher.Publisher;

public class PublisherClosed extends PublisherStatus {
	
	

	public PublisherClosed() {
		super();
		this.setCode(CLOSED);
	}

	@Override
	public void lock(Publisher publisher) throws PublisherStatusException {
		String message = "当前已经关闭，不需再锁定！";
		throw new PublisherStatusException(message);		
	}

	@Override
	public void close(Publisher publisher) throws PublisherStatusException {
		String message = "当前已经关闭，不需再次关闭！";
		throw new PublisherStatusException(message);		
		
	}

	@Override
	public void reopen(Publisher publisher) throws PublisherStatusException {
		publisher.changeStatus(new PublisherOnline());	
		
	}

	
	

}
