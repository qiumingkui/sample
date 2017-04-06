package com.qiumingkui.sample.imedia.common.domain.id;

import java.io.Serializable;

public interface DomainEntityId<K> extends Serializable{

	public K id();

}
