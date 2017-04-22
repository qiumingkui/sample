//   Copyright 2012,2013 Vaughn Vernon
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package com.qiumingkui.sample.imedia.blog.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiumingkui.sample.imedia.common.event.EventStore;
import com.qiumingkui.sample.imedia.common.event.MemoryEventStore;
import com.qiumingkui.sample.imedia.common.notification.NotificationLog;
import com.qiumingkui.sample.imedia.common.notification.NotificationLogFactory;
import com.qiumingkui.sample.imedia.common.notification.NotificationLogId;
import com.qiumingkui.sample.imedia.common.notification.NotificationPublisher;

@Service
public class NotificationApplicationService {

	// @Autowired
	private EventStore eventStore = new MemoryEventStore();;

//	@Autowired
//	private NotificationPublisher notificationPublisher;

	public NotificationApplicationService() {
		super();
	}

	public NotificationLog currentNotificationLog() {
		NotificationLogFactory factory = new NotificationLogFactory(this.eventStore());

		return factory.createCurrentNotificationLog();
	}

	public NotificationLog notificationLog(String aNotificationLogId) {
		NotificationLogFactory factory = new NotificationLogFactory(this.eventStore());

		return factory.createNotificationLog(new NotificationLogId(aNotificationLogId));
	}

//	public void publishNotifications() {
//		this.notificationPublisher().publishNotifications();
//	}

	protected EventStore eventStore() {
		return this.eventStore;
	}

//	protected NotificationPublisher notificationPublisher() {
//		return this.notificationPublisher;
//	}
}
