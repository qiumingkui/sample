package com.qiumingkui.sample.imedia.asset.domain.model.operation;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.asset.domain.model.account.AssetAccount;
import com.qiumingkui.sample.imedia.asset.domain.model.account.point.PointAdd;

public class AccumulatePoint implements AssetOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PointAdd pointAdd;

	private Timestamp createTime;

	private Timestamp modifyTime;
	
	private boolean executed;

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isExecuted() {
		// TODO Auto-generated method stub
		
	}

}
