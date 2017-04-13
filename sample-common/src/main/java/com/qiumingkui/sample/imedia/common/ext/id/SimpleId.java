package com.qiumingkui.sample.imedia.common.ext.id;

public interface SimpleId<K, T extends SimpleId<?, ?>> extends Identity<T>{

	public K key();
	
	public boolean equals(T id);
}
