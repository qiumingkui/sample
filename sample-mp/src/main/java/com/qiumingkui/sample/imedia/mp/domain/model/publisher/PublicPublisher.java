package com.qiumingkui.sample.imedia.mp.domain.model.publisher;

import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.mp.domain.model.member.Owner;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.rank.PublisherRank;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.status.PublisherStatus;

public class PublicPublisher extends Publisher {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     
	private PublicPublisherId publicPublisherId;
	
	public PublicPublisher(PublicPublisherId aPublicPublisherId, Owner aOwner, PublisherPost aMediaPublisherPost) {
		super(aPublicPublisherId, aOwner, aMediaPublisherPost);

		this.setCode(MEDIA_PUBLISHER);
		this.setPublicPublisherId(aPublicPublisherId);
		
	}

	public PublicPublisher(PublicPublisherId aPublicPublisherId, Owner aOwner, PublisherPost aMediaPublisherPost, PublisherRank rank,
			PublisherStatus aBloggerStatus, Timestamp aCreateTime, Timestamp aModifyTime) {
		super(aPublicPublisherId, aOwner, aMediaPublisherPost, rank, aBloggerStatus, aCreateTime, aModifyTime);

		this.setCode(MEDIA_PUBLISHER);
		this.setPublicPublisherId(aPublicPublisherId);
	}

	/**
	 * @return the publicPublisherId
	 */
	public PublicPublisherId publicPublisherId() {
		return publicPublisherId;
	}

	/**
	 * @param publicPublisherId the publicPublisherId to set
	 */
	private void setPublicPublisherId(PublicPublisherId publicPublisherId) {
		this.publicPublisherId = publicPublisherId;
	}

}
