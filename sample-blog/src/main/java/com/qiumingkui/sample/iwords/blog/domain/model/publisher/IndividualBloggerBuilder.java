package com.qiumingkui.sample.iwords.blog.domain.model.publisher;

import java.sql.Timestamp;

import com.qiumingkui.sample.iwords.blog.domain.model.member.Owner;
import com.qiumingkui.sample.iwords.blog.domain.model.publisher.rank.PublisherRank;
import com.qiumingkui.sample.iwords.blog.domain.model.publisher.status.PublisherStatus;

public class IndividualBloggerBuilder {

	public static IndividualBlogger build(IndividualBloggerId aIndividualBloggerId, Owner aOwner, PublisherPost aPostInfo) {

		return new IndividualBlogger(aIndividualBloggerId, aOwner, aPostInfo);
	}

	public static IndividualBlogger build(IndividualBloggerId aIndividualBloggerId, Owner aOwner, PublisherPost aPostInfo,
			PublisherRank rank, PublisherStatus aBloggerStatus, Timestamp aCreateTime, Timestamp aModifyTime) {

		return new IndividualBlogger(aIndividualBloggerId, aOwner, aPostInfo, rank, aBloggerStatus, aCreateTime, aModifyTime);
	}
}
