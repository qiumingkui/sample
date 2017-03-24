package com.qiumingkui.sample.imedia.mp.domain.model.publisher.status;

import com.qiumingkui.sample.imedia.mp.domain.model.publisher.Publisher;

public class PublisherOnline extends PublisherStatus {
	
	public PublisherOnline() {
		super();
		this.setCode(ONLINE);
	}

	@Override
	public void lock(Publisher publisher) throws PublisherStatusException {
		publisher.changeStatus(new PublisherLocked());	
		
	}

	@Override
	public void close(Publisher publisher) throws PublisherStatusException {
		publisher.changeStatus(new PublisherClosed());	

		
	}

	@Override
	public void reopen(Publisher publisher) throws PublisherStatusException {
		String message = "当前已经在正常在线，不需重新打开！";
		throw new PublisherStatusException(message);	
	}

	
}
