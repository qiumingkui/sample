package com.qiumingkui.sample.imedia.blog.domain.model.blogger;

import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.blog.domain.model.blogger.rank.BloggerRank;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.rank.Novice;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.status.BloggerStatus;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.status.BloggerStatusException;
import com.qiumingkui.sample.imedia.blog.domain.model.blogger.status.Online;
import com.qiumingkui.sample.imedia.blog.domain.model.blogmember.BlogOwner;
import com.qiumingkui.sample.imedia.common.domain.entity.IdentityEntity;
import com.qiumingkui.sample.imedia.common.util.DateTimeUtil;

public class Blogger implements IdentityEntity<BloggerId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BloggerId id;

	private BlogOwner blogOwner;

	private BloggerPost bloggerPost;

	private BloggerRank rank;

	private BloggerStatus status;

	private Timestamp createTime;

	private Timestamp modifyTime;

	protected Blogger() {
		super();
	}

	protected Blogger create(BloggerId aId, BlogOwner aOwner) {

		this.init(aId, aOwner, new BloggerPost(0, 0), new Novice(), new Online(), DateTimeUtil.nowTimestamp(),
				DateTimeUtil.nowTimestamp());
		return this;
	}

	protected void init(BloggerId aId, BlogOwner aOwner, BloggerPost aBloggerPost, BloggerRank aRank, BloggerStatus aStatus,
			Timestamp aCreateTime, Timestamp aModifyTime) {

		this.setId(aId);
		this.setOwner(aOwner);
		this.setBloggerPost(aBloggerPost);
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

	public void changeBloggerPost(BloggerPost aBloggerPost) {
		this.setBloggerPost(aBloggerPost);
	}

	public void changeRank(BloggerRank aRank) {
		this.setRank(aRank);
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

	private void setId(BloggerId aId) {
		this.id = aId;
	}

	private void setOwner(BlogOwner aOwner) {
		this.blogOwner = aOwner;
	}

	private void setBloggerPost(BloggerPost aBloggerPost) {
		this.bloggerPost = aBloggerPost;
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
