package com.qiumingkui.sample.imedia.blog.domain.model.blogger;

import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.blog.domain.model.blogger.rank.BloggerRank;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.status.BloggerStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.status.BloggerStatusException;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.status.BloggerClosedStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.status.BloggerLockedStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.status.BloggerOnlineStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogOwner;
import com.qiumingkui.sample.imedia.common.ext.entity.IdentityEntity;
import com.qiumingkui.sample.imedia.common.ext.util.DateTimeUtil;

public class Blogger implements IdentityEntity<BloggerId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BloggerId id;

	private BlogOwner blogOwner;

	private BloggerBlogEntryVal blogEntryVal;

	private BloggerRank rank;

	private BloggerStatus status;

	private Timestamp createTime;

	private Timestamp modifyTime;

	private Blogger() {
		super();
	}

	public Blogger(BloggerId aId, BlogOwner aOwner) {
		this();
		this.init(aId, aOwner, new BloggerBlogEntryVal(0, 0), BloggerRank.NOVICE, new BloggerOnlineStatus(),
				DateTimeUtil.nowTimestamp(), DateTimeUtil.nowTimestamp());
	}

	public Blogger(BloggerId aId, BlogOwner aOwner, BloggerBlogEntryVal aBloggerBlogEntryVal, BloggerRank aRank, BloggerStatus aStatus,
			Timestamp aCreateTime, Timestamp aModifyTime) {
		this();
		this.init(aId, aOwner, aBloggerBlogEntryVal, aRank, aStatus, aCreateTime, aModifyTime);
	}

	private void init(BloggerId aId, BlogOwner aOwner, BloggerBlogEntryVal aBloggerBlogEntryVal, BloggerRank aRank,
			BloggerStatus aStatus, Timestamp aCreateTime, Timestamp aModifyTime) {

		this.setId(aId);
		this.setOwner(aOwner);
		this.setBlogEntryVal(aBloggerBlogEntryVal);
		this.setRank(aRank);
		this.setStatus(aStatus);
		this.setCreateTime(aCreateTime);
		this.setModifyTime(aModifyTime);
	}

	@Override
	public BloggerId id() {
		return id;
	}

	public BlogOwner blogOwner() {
		return blogOwner;
	}

	public BloggerBlogEntryVal blogEntryVal() {
		return blogEntryVal;
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

	public void changeBlogEntryVal(BloggerBlogEntryVal aBloggerBlogEntryVal) {
		this.setBlogEntryVal(aBloggerBlogEntryVal);
	}

	public void changeRank(BloggerRank aRank) {
		this.setRank(aRank);
	}

	// public void changeStatus(BloggerStatus aStatus) {
	// this.setStatus(aStatus);
	// }

	public void reopen() throws BloggerStatusException {
		this.status.reopen();
		this.setStatus(new BloggerOnlineStatus());
	}

	public void lock() throws BloggerStatusException {
		this.status.lock();
		this.setStatus(new BloggerLockedStatus());
	}

	public void close() throws BloggerStatusException {
		this.status.close();
		this.setStatus(new BloggerClosedStatus());
	}

	private void setId(BloggerId aId) {
		this.id = aId;
	}

	private void setOwner(BlogOwner aOwner) {
		this.blogOwner = aOwner;
	}

	private void setBlogEntryVal(BloggerBlogEntryVal aBlogEntryVal) {
		this.blogEntryVal = aBlogEntryVal;
	}

	private void setStatus(BloggerStatus aBloggerStatus) {
		this.status = aBloggerStatus;
	}

	private void setCreateTime(Timestamp aCreateTime) {
		this.createTime = aCreateTime;
	}

	private void setModifyTime(Timestamp aModifyTime) {
		this.modifyTime = aModifyTime;
	}

	private void setRank(BloggerRank aRank) {
		this.rank = aRank;
	}

}
