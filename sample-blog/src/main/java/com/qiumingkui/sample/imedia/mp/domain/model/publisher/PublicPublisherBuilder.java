package com.qiumingkui.sample.imedia.mp.domain.model.publisher;

import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.mp.domain.model.member.Owner;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.rank.PublisherRank;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.status.PublisherStatus;

public class PublicPublisherBuilder {

	public static PublicPublisher build(PublicPublisherId aMediaPublisherId, Owner aOwner, PublisherPost aPostInfo) {

		return new PublicPublisher(aMediaPublisherId, aOwner, aPostInfo);
	}

	public static PublicPublisher build(PublicPublisherId aMediaPublisherId, Owner aOwner, PublisherPost aPostInfo,
			PublisherRank rank, PublisherStatus aBloggerStatus, Timestamp aCreateTime, Timestamp aModifyTime) {

		return new PublicPublisher(aMediaPublisherId, aOwner, aPostInfo, rank, aBloggerStatus, aCreateTime, aModifyTime);
	}

}
