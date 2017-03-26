package com.qiumingkui.sample.imedia.asset.domain.model.operation;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.asset.domain.model.account.point.PointAdd;
import com.qiumingkui.sample.imedia.asset.domain.model.account.point.PointSubtract;
import com.qiumingkui.sample.imedia.asset.domain.model.account.rmb.RmbAdd;
import com.qiumingkui.sample.imedia.asset.domain.model.account.rmb.RmbSubtract;

public class Accumulate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PointAdd pointAdd;
	
	private Timestamp createTime;

	private Timestamp modifyTime;

}
