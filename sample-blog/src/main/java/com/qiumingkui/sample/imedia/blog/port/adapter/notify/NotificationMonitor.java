package com.qiumingkui.sample.imedia.blog.port.adapter.notify;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qiumingkui.sample.imedia.blog.application.NotificationApplicationService;

@Component
public class NotificationMonitor {

	@Autowired
	private NotificationApplicationService notificationApplicationService;

	@PostConstruct
	public void init() {
		NotificationMonitorTimer timer = NotificationMonitorTimer.newInstance(notificationApplicationService);
		timer.start();
		System.out.println("NotificationMonitor is started!");
	}

}
