package com.qiumingkui.sample.iwords.blog.domain.model.publisher;

import java.sql.Timestamp;

import com.qiumingkui.sample.iwords.blog.domain.model.member.Owner;
import com.qiumingkui.sample.iwords.blog.domain.model.publisher.rank.PublisherRank;
import com.qiumingkui.sample.iwords.blog.domain.model.publisher.status.PublisherStatus;

public class IndividualBlogger extends Publisher {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IndividualBloggerId individualBloggerId;

	public IndividualBlogger(IndividualBloggerId aIndividualBloggerId, Owner aOwner, PublisherPost aPostInfo) {
		super(aIndividualBloggerId, aOwner, aPostInfo);
		
        this.setPersonalBloggerId(aIndividualBloggerId);
		this.setCode(PERSONAL_BLOGGER);
	}

	public IndividualBlogger(IndividualBloggerId aIndividualBloggerId, Owner aOwner, PublisherPost aPostInfo, PublisherRank rank,
			PublisherStatus aBloggerStatus, Timestamp aCreateTime, Timestamp aModifyTime) {
		super(aIndividualBloggerId, aOwner, aPostInfo, rank, aBloggerStatus, aCreateTime, aModifyTime);
		
		this.setPersonalBloggerId(aIndividualBloggerId);
		this.setCode(PERSONAL_BLOGGER);
	}

	public IndividualBloggerId individualBloggerId() {
		return individualBloggerId;
	}

	private void setPersonalBloggerId(IndividualBloggerId aIndividualBloggerId) {
		this.individualBloggerId = aIndividualBloggerId;
	}

}
