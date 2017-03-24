package com.qiumingkui.sample.imedia.mp.domain.model.publisher;

import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.mp.domain.model.member.Owner;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.rank.PublisherRank;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.status.PublisherStatus;

public class IndividualPublisherBuilder {

	public static IndividualPublisher build(IndividualPublisherId aIndividualPublisherId, Owner aOwner, PublisherPost aMediaPublisherPost) {

		return new IndividualPublisher(aIndividualPublisherId, aOwner, aMediaPublisherPost);
	}

	public static IndividualPublisher build(IndividualPublisherId IndividualPublisherId, Owner aOwner, PublisherPost aMediaPublisherPost,
			PublisherRank rank, PublisherStatus aBloggerStatus, Timestamp aCreateTime, Timestamp aModifyTime) {

		return new IndividualPublisher(IndividualPublisherId, aOwner, aMediaPublisherPost, rank, aBloggerStatus, aCreateTime, aModifyTime);
	}
}
