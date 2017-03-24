package com.qiumingkui.sample.imedia.user.domain.model;

import com.qiumingkui.sample.imedia.common.domain.model.EntityId;

public class UserId extends EntityId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserId(String id) {
		super(id);
	}

	// public boolean equals(UserId userId) {
	// if(userId!=null &&userId.id.equals(this.id())){
	// return true;
	// }
	// return false;
	// }
}
