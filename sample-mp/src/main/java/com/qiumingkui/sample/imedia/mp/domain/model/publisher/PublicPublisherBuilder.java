package com.qiumingkui.sample.imedia.mp.domain.model.publisher;

import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.mp.domain.model.member.Owner;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.rank.BloggerRank;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.status.BloggerStatus;

public class PublicPublisherBuilder {

	public static PublicPublisher build(PublicPublisherId aMediaPublisherId, Owner aOwner, BloggerPost aPostInfo) {

		return new PublicPublisher(aMediaPublisherId, aOwner, aPostInfo);
	}

	public static PublicPublisher build(PublicPublisherId aMediaPublisherId, Owner aOwner, BloggerPost aPostInfo,
			BloggerRank rank, BloggerStatus aBloggerStatus, Timestamp aCreateTime, Timestamp aModifyTime) {

		return new PublicPublisher(aMediaPublisherId, aOwner, aPostInfo, rank, aBloggerStatus, aCreateTime, aModifyTime);
	}

}
