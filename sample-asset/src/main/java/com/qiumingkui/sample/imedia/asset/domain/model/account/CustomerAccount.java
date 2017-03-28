package com.qiumingkui.sample.imedia.asset.domain.model.account;

import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.asset.domain.model.member.Owner;

public class CustomerAccount extends AssetAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerAccount(AssetAccountId aAssetAccountId, PointBalance aPointBalance, RmbBalance aRmbBalance,
			Owner aOwner, Timestamp aCreateTime, Timestamp aModifyTime) {
		super(aAssetAccountId, aPointBalance, aRmbBalance, aOwner, aCreateTime, aModifyTime);
	}

}
