package com.qiumingkui.sample.iwords.blog.domain.model.publisher;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.iwords.blog.domain.model.member.Owner;
import com.qiumingkui.sample.iwords.blog.domain.model.publisher.rank.Novice;
import com.qiumingkui.sample.iwords.blog.domain.model.publisher.rank.PublisherRank;
import com.qiumingkui.sample.iwords.blog.domain.model.publisher.status.PublisherOnline;
import com.qiumingkui.sample.iwords.blog.domain.model.publisher.status.PublisherStatus;
import com.qiumingkui.sample.iwords.blog.domain.model.publisher.status.PublisherStatusException;
import com.qiumingkui.sample.iwords.common.util.UtilDateTime;

public abstract class Publisher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int MEDIA_PUBLISHER = 1;

	public static final int PERSONAL_BLOGGER = 0;

	private int code;

	private PublisherId publisherId;

	private Owner owner;

	private PostInfo postInfo;

	private PublisherRank rank;

	private PublisherStatus status;

	private Timestamp createTime;

	private Timestamp modifyTime;

	protected Publisher() {
		super();
	}

	protected Publisher(PublisherId aBloggerId, Owner aOwner, PostInfo aPostInfo) {
		this(aBloggerId, aOwner, aPostInfo, new Novice(), new PublisherOnline(), UtilDateTime.nowTimestamp(),
				UtilDateTime.nowTimestamp());
	}

	protected Publisher(PublisherId aBloggerId, Owner aOwner, PostInfo aPostInfo, PublisherRank rank,
			PublisherStatus aBloggerStatus, Timestamp aCreateTime, Timestamp aModifyTime) {
		this();
		this.setBloggerId(aBloggerId);
		this.setOwner(aOwner);
		this.setPostInfo(aPostInfo);
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

	public PostInfo postInfo() {
		return postInfo;
	}

	public PublisherRank rank() {
		return rank;
	}

	public PublisherStatus status() {
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

	public void changePostInfo(PostInfo aPostInfo) {
		this.setPostInfo(aPostInfo);
	}

	public void changeRank(PublisherRank rank) {
		this.setRank(rank);
	}

	public void changeStatus(PublisherStatus aStatus) {
		this.setStatus(aStatus);
	}

	public void reopen() throws PublisherStatusException {
		this.status.reopen(this);
	}

	public void lock() throws PublisherStatusException {
		this.status.lock(this);
	}

	public void close() throws PublisherStatusException {
		this.status.close(this);
	}

	private void setBloggerId(PublisherId aBloggerId) {
		this.publisherId = aBloggerId;
	}

	private void setOwner(Owner aOwner) {
		this.owner = aOwner;
	}

	private void setPostInfo(PostInfo aPostInfo) {
		this.postInfo = aPostInfo;
	}

	private void setStatus(PublisherStatus aBloggerStatus) {
		this.status = aBloggerStatus;
	}

	private void setCreateTime(Timestamp aCreateTime) {
		this.createTime = aCreateTime;
	}

	private void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	private void setRank(PublisherRank rank) {
		this.rank = rank;
	}

	protected void setCode(int code) {
		this.code = code;
	}

}
