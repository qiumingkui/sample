package com.qiumingkui.sample.imedia.common.ext.entity;

import com.qiumingkui.sample.imedia.common.ext.version.ConcurrencyVersion;

/**
 * 并发实体
 * 
 * @author Administrator
 *
 */
public interface ConcurrencyEntity extends Entity {

	/**
	 * 实体版本
	 * 
	 * @return
	 */
	public ConcurrencyVersion version();
}
