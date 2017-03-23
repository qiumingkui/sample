package com.qiumingkui.sample.iwords.blog.domain.model.blogger;

import java.io.Serializable;
import java.sql.Timestamp;

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

	private Timestamp createTime;

	private Timestamp modifyTime;

	private Blogger() {
		super();
	}

	public Blogger(BloggerId bloggerId, Owner owner, int postNumber) {
		this(bloggerId, owner, postNumber, UtilDateTime.nowTimestamp(), UtilDateTime.nowTimestamp());
	}

	public Blogger(BloggerId bloggerId, Owner owner, int postNumber, Timestamp createTime, Timestamp modifyTime) {
		this();
		this.setBloggerId(bloggerId);
		this.setOwner(owner);
		this.setPostNumber(postNumber);
		this.setCreateTime(createTime);
		this.setModifyTime(modifyTime);
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

	public Timestamp createTime() {
		return createTime;
	}

	public Timestamp modifyTime() {
		return modifyTime;
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

	private void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	private void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

}
