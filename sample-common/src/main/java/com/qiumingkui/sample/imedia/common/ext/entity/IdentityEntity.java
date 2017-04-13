package com.qiumingkui.sample.imedia.common.ext.entity;

import com.qiumingkui.sample.imedia.common.ext.id.Identity;

public interface IdentityEntity<K extends Identity> extends Entity {

	public K id();
}
