package com.qiumingkui.sample.iwords.blog.domain.model.blogger;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.iwords.blog.domain.model.blogger.rank.Junior;
import com.qiumingkui.sample.iwords.blog.domain.model.blogger.rank.BloggerRank;
import com.qiumingkui.sample.iwords.blog.domain.model.blogger.status.BloggerOnline;
import com.qiumingkui.sample.iwords.blog.domain.model.blogger.status.BloggerStatus;
import com.qiumingkui.sample.iwords.blog.domain.model.blogger.status.BloggerStatusException;
import com.qiumingkui.sample.iwords.blog.domain.model.member.Owner;
import com.qiumingkui.sample.iwords.common.util.UtilDateTime;

public class Blogger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BloggerId bloggerId;

	private Owner owner;

	private BloggerPostInfo postInfo;

	private BloggerRank rank;
	
	public void changeRank(BloggerRank rank) {
		this.setRank(rank);
	}
	
	public BloggerRank rank() {
		return rank;
	}

	private void setRank(BloggerRank rank) {
		this.rank = rank;
	}

	private BloggerStatus status;

	private Timestamp createTime;

	private Timestamp modifyTime;

	private Blogger() {
		super();
	}

	public Blogger(BloggerId aBloggerId, Owner aOwner, BloggerPostInfo aPostInfo) {
		this(aBloggerId, aOwner, aPostInfo, new Junior(), new BloggerOnline(), UtilDateTime.nowTimestamp(),
				UtilDateTime.nowTimestamp());
	}

	public Blogger(BloggerId aBloggerId, Owner aOwner, BloggerPostInfo aPostInfo, BloggerRank rank,BloggerStatus aBloggerStatus,
			Timestamp aCreateTime, Timestamp aModifyTime) {
		this();
		this.setBloggerId(aBloggerId);
		this.setOwner(aOwner);
		this.setPostInfo(aPostInfo);
		this.setRank(rank);
		this.setStatus(aBloggerStatus);
		this.setCreateTime(aCreateTime);
		this.setModifyTime(aModifyTime);
	}

	public BloggerId bloggerId() {
		return bloggerId;
	}

	public Owner owner() {
		return owner;
	}

	public BloggerPostInfo postInfo(){
		return postInfo;
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

	public void changePostInfo(BloggerPostInfo aPostInfo){
		this.setPostInfo(aPostInfo);
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

	private void setBloggerId(BloggerId aBloggerId) {
		this.bloggerId = aBloggerId;
	}

	private void setOwner(Owner aOwner) {
		this.owner = aOwner;
	}

	private void setPostInfo(BloggerPostInfo aPostInfo) {
		this.postInfo = aPostInfo;
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

}
