package com.qiumingkui.sample.imedia.common.domain.entity;

import com.qiumingkui.sample.imedia.common.domain.version.ConcurrencyVersion;

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
