package com.qiumingkui.sample.imedia.mp.domain.model.publisher;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.common.util.UtilDateTime;
import com.qiumingkui.sample.imedia.mp.domain.model.member.Owner;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.rank.Novice;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.rank.BloggerRank;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.status.Online;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.status.BloggerStatus;
import com.qiumingkui.sample.imedia.mp.domain.model.publisher.status.BloggerStatusException;

public abstract class Publisher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int PUBLIC_PUBLISHER = 1;

	public static final int INDIVIDUAL_PUBLISHER = 0;

	private int code;

	private PublisherId publisherId;

	private Owner owner;

	private BloggerPost bloggerPost;

	private BloggerRank rank;

	private BloggerStatus status;

	private Timestamp createTime;

	private Timestamp modifyTime;

	protected Publisher() {
		super();
	}

	protected Publisher(PublisherId aMediaPublisherId, Owner aOwner, BloggerPost aPublisherPost) {
		this(aMediaPublisherId, aOwner, aPublisherPost, new Novice(), new Online(), UtilDateTime.nowTimestamp(),
				UtilDateTime.nowTimestamp());
	}

	protected Publisher(PublisherId aMediaPublisherId, Owner aOwner, BloggerPost aPublisherPost, BloggerRank rank,
			BloggerStatus aBloggerStatus, Timestamp aCreateTime, Timestamp aModifyTime) {
		this();
		this.setBloggerId(aMediaPublisherId);
		this.setOwner(aOwner);
		this.setPublisherPost(aPublisherPost);
		this.setRank(rank);
		this.setStatus(aBloggerStatus);
		this.setCreateTime(aCreateTime);
		this.setModifyTime(aModifyTime);
	}

	public PublisherId publisherId() {
		return publisherId;
	}

	public Owner owner() {
		return owner;
	}

	public BloggerPost bloggerPost() {
		return bloggerPost;
	}

	public BloggerRank rank() {
		return rank;
	}

	public BloggerStatus status() {
		return status;
	}

	public Timestamp createTime() {
		return createTime;
	}

	public Timestamp modifyTime() {
		return modifyTime;
	}

	public int code() {
		return code;
	}

	public void changePublisherPost(BloggerPost aPublisherPost) {
		this.setPublisherPost(aPublisherPost);
	}

	public void changeRank(BloggerRank rank) {
		this.setRank(rank);
	}

	public void changeStatus(BloggerStatus aStatus) {
		this.setStatus(aStatus);
	}

	public void reopen() throws BloggerStatusException {
		this.status.reopen(this);
	}

	public void lock() throws BloggerStatusException {
		this.status.lock(this);
	}

	public void close() throws BloggerStatusException {
		this.status.close(this);
	}

	private void setBloggerId(PublisherId aBloggerId) {
		this.publisherId = aBloggerId;
	}

	private void setOwner(Owner aOwner) {
		this.owner = aOwner;
	}

	private void setPublisherPost(BloggerPost aPostInfo) {
		this.bloggerPost = aPostInfo;
	}

	private void setStatus(BloggerStatus aBloggerStatus) {
		this.status = aBloggerStatus;
	}

	private void setCreateTime(Timestamp aCreateTime) {
		this.createTime = aCreateTime;
	}

	private void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	private void setRank(BloggerRank rank) {
		this.rank = rank;
	}

	protected void setCode(int code) {
		this.code = code;
	}

}
