package com.qiumingkui.sample.imedia.mp.domain.model.publisher;

import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.mp.domain.model.member.Owner;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.rank.BloggerRank;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.status.BloggerStatus;

public class PublicPublisher extends Publisher {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     
	private PublicPublisherId publicPublisherId;
	
	public PublicPublisher(PublicPublisherId aPublicPublisherId, Owner aOwner, BloggerPost aMediaPublisherPost) {
		super(aPublicPublisherId, aOwner, aMediaPublisherPost);

		this.setCode(PUBLIC_PUBLISHER);
		this.setPublicPublisherId(aPublicPublisherId);
		
	}

	public PublicPublisher(PublicPublisherId aPublicPublisherId, Owner aOwner, BloggerPost aMediaPublisherPost, BloggerRank rank,
			BloggerStatus aBloggerStatus, Timestamp aCreateTime, Timestamp aModifyTime) {
		super(aPublicPublisherId, aOwner, aMediaPublisherPost, rank, aBloggerStatus, aCreateTime, aModifyTime);

		this.setCode(PUBLIC_PUBLISHER);
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
