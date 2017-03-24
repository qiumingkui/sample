package com.qiumingkui.sample.iwords.blog.domain.model.publisher;

import java.sql.Timestamp;

import com.qiumingkui.sample.iwords.blog.domain.model.member.Owner;
import com.qiumingkui.sample.iwords.blog.domain.model.publisher.rank.PublisherRank;
import com.qiumingkui.sample.iwords.blog.domain.model.publisher.status.PublisherStatus;

public class MediaPublisherBuilder {

	public static MediaPublisher build(MediaPublisherId aMediaPublisherId, Owner aOwner, PublisherPost aPostInfo) {

		return new MediaPublisher(aMediaPublisherId, aOwner, aPostInfo);
	}

	public static MediaPublisher build(MediaPublisherId aMediaPublisherId, Owner aOwner, PublisherPost aPostInfo,
			PublisherRank rank, PublisherStatus aBloggerStatus, Timestamp aCreateTime, Timestamp aModifyTime) {

		return new MediaPublisher(aMediaPublisherId, aOwner, aPostInfo, rank, aBloggerStatus, aCreateTime, aModifyTime);
	}

}
