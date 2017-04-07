package com.qiumingkui.sample.imedia.common.domain.id;

public interface KeyId<K,T extends KeyId<?, ?>> extends Identity{

	public K key();
	
	public boolean equals(T id);

}
