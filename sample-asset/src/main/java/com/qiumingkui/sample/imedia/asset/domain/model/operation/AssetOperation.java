package com.qiumingkui.sample.imedia.asset.domain.model.operation;

import java.io.Serializable;

public interface AssetOperation extends Serializable {
	
	public void execute();
	
	public void isExecuted();

//	public Timestamp createTime();
//	
//	public Timestamp modifyTime();
	
	
}
