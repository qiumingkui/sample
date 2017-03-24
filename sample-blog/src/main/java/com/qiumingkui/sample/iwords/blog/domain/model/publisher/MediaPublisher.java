package com.qiumingkui.sample.iwords.blog.domain.model.publisher;

import java.sql.Timestamp;

import com.qiumingkui.sample.iwords.blog.domain.model.member.Owner;
import com.qiumingkui.sample.iwords.blog.domain.model.publisher.rank.PublisherRank;
import com.qiumingkui.sample.iwords.blog.domain.model.publisher.status.PublisherStatus;

public class MediaPublisher extends Publisher {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     
	private MediaPublisherId mediaPublisherId;
	
	public MediaPublisher(MediaPublisherId aMediaPublisherId, Owner aOwner, PostInfo aPostInfo) {
		super(aMediaPublisherId, aOwner, aPostInfo);

		this.setCode(MEDIA_PUBLISHER);
	}

	public MediaPublisher(MediaPublisherId aMediaPublisherId, Owner aOwner, PostInfo aPostInfo, PublisherRank rank,
			PublisherStatus aBloggerStatus, Timestamp aCreateTime, Timestamp aModifyTime) {
		super(aMediaPublisherId, aOwner, aPostInfo, rank, aBloggerStatus, aCreateTime, aModifyTime);

		this.setCode(MEDIA_PUBLISHER);
	}

}
