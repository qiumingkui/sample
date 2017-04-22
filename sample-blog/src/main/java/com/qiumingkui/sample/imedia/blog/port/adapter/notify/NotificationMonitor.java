package com.qiumingkui.sample.imedia.blog.port.adapter.notify;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qiumingkui.sample.imedia.blog.application.NotificationApplicationService;
import com.qiumingkui.sample.imedia.common.notification.Notification;
import com.qiumingkui.sample.imedia.common.notification.NotificationLog;
import com.qiumingkui.sample.imedia.common.notification.NotificationLogId;

public class NotificationMonitor {
	
	
	private static NotificationApplicationService notificationApplicationService;

	static {
		NotificationMonitorTimer timer = new NotificationMonitorTimer();
		
		notificationApplicationService= new NotificationApplicationService();
		timer.start();
		System.out.println("NotificationMonitor is started!");
	}

	private static class NotificationMonitorTimer extends Thread {


		private static NotificationLogId notificationLogId = new NotificationLogId(0, 0);

		public NotificationMonitorTimer() {
			super();
		}

		@Override
		public void run() {
			while (true) {
				try {
					System.out.println("notificationLogId :"+notificationLogId);
					NotificationLog notificationLog = notificationApplicationService
							.notificationLog(notificationLogId.encoded());
					List<Notification> notifications = notificationLog.notifications();
					System.out.println("notification size:"+notifications.size());
					for(Notification notification:notifications){
						notification.event();
						System.out.println("notification :"+notification);
						
					}
					
					notificationLogId = notificationLogId.next(20);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Problem read notifications.");
				}

				try {
					Thread.sleep(100L);
				} catch (Exception e) {
					// ignore
				}
			}
		}
	}
}
