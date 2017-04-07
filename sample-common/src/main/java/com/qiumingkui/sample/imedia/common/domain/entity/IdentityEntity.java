package com.qiumingkui.sample.imedia.common.domain.entity;

import com.qiumingkui.sample.imedia.common.domain.id.Identity;

public interface IdentityEntity<K extends Identity> extends Entity {

	public K id();
}
