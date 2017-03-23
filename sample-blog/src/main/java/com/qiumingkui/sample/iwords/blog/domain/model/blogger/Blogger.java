package com.qiumingkui.sample.iwords.blog.domain.model.blogger;

import java.io.Serializable;
import java.sql.Timestamp;

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

	private int postNumber;

	private BloggerStatus status;

	private Timestamp createTime;

	private Timestamp modifyTime;

	private Blogger() {
		super();
	}

	public Blogger(BloggerId aBloggerId, Owner aOwner, int aPostNumber) {
		this(aBloggerId, aOwner, aPostNumber, new BloggerOnline(), UtilDateTime.nowTimestamp(), UtilDateTime.nowTimestamp());
	}

	public Blogger(BloggerId aBloggerId, Owner aOwner, int aPostNumber, BloggerStatus aBloggerStatus,
			Timestamp aCreateTime, Timestamp aModifyTime) {
		this();
		this.setBloggerId(bloggerId);
		this.setOwner(owner);
		this.setPostNumber(postNumber);
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

	public int postNumber() {
		return postNumber;
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

	private void setBloggerId(BloggerId bloggerId) {
		this.bloggerId = bloggerId;
	}

	private void setOwner(Owner owner) {
		this.owner = owner;
	}

	private void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}

	private void setStatus(BloggerStatus bloggerStatus) {
		this.status = bloggerStatus;
	}

	private void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	private void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

}
