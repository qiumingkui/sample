
package com.qiumingkui.sample.imedia.asset.domain.model.operation;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.asset.domain.model.account.point.PointAdd;
import com.qiumingkui.sample.imedia.asset.domain.model.account.point.PointSubtract;

public class DonatePoint implements AssetOperation {

	private static final long serialVersionUID = 1L;

	private PointAdd doneePointAdd;

	private PointSubtract donorPointSubtract;

	private Timestamp createTime;

	private Timestamp modifyTime;

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isExecuted() {
		// TODO Auto-generated method stub
		
	}

}
