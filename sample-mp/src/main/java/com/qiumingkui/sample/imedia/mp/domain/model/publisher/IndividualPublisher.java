package com.qiumingkui.sample.imedia.mp.domain.model.publisher;

import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.mp.domain.model.member.Owner;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.rank.PublisherRank;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.status.PublisherStatus;

public class IndividualPublisher extends Publisher {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IndividualPublisherId individualPublisherId;

	public IndividualPublisher(IndividualPublisherId aIndividualPublisher, Owner aOwner, PublisherPost aMediaPublisherPost) {
		super(aIndividualPublisher, aOwner, aMediaPublisherPost);
		
        this.setIndividualPublisherId(aIndividualPublisher);
		this.setCode(INDIVIDUAL_PUBLISHER);
	}

	public IndividualPublisher(IndividualPublisherId aIndividualPublisherId, Owner aOwner, PublisherPost aMediaPublisherPost, PublisherRank rank,
			PublisherStatus aBloggerStatus, Timestamp aCreateTime, Timestamp aModifyTime) {
		super(aIndividualPublisherId, aOwner, aMediaPublisherPost, rank, aBloggerStatus, aCreateTime, aModifyTime);
		
		this.setIndividualPublisherId(aIndividualPublisherId);
		this.setCode(INDIVIDUAL_PUBLISHER);
	}

	public IndividualPublisherId individualPublisherId() {
		return individualPublisherId;
	}

	private void setIndividualPublisherId(IndividualPublisherId aIndividualBloggerId) {
		this.individualPublisherId = aIndividualBloggerId;
	}

}
