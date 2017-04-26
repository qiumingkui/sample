package com.qiumingkui.sample.imedia.blog.port.adapter.notify;

import java.util.List;

import com.qiumingkui.sample.imedia.blog.application.NotificationApplicationService;
import com.qiumingkui.sample.imedia.common.notification.Notification;
import com.qiumingkui.sample.imedia.common.notification.NotificationLog;
import com.qiumingkui.sample.imedia.common.notification.NotificationLogId;

public class NotificationMonitorTimer extends Thread {
	private static NotificationMonitorTimer single;

	private NotificationApplicationService notificationApplicationService;

	private NotificationLogId notificationLogId = new NotificationLogId(0, 20);

	private NotificationMonitorTimer() {
		super();
	}

	public synchronized static NotificationMonitorTimer newInstance(
			NotificationApplicationService notificationApplicationService) {
		if (single == null) {
			single = new NotificationMonitorTimer();
		}

		single.setNotificationApplicationService(notificationApplicationService);
		return single;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("notificationLogId :" + notificationLogId);
				NotificationLog notificationLog = notificationApplicationService
						.notificationLog(notificationLogId.encoded());
				List<Notification> notifications = notificationLog.notifications();
				System.out.println("notification size:" + notifications.size());
				for (Notification notification : notifications) {
					notification.event();
					System.out.println("notification :" + notification);

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

	private void setNotificationApplicationService(NotificationApplicationService notificationApplicationService) {
		this.notificationApplicationService = notificationApplicationService;
	}
}
