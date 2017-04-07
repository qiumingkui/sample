package com.qiumingkui.sample.imedia.common.domain.id;

public interface CompositeId<T extends CompositeId<?>> extends Identity{

	public boolean equals(T id);
}
