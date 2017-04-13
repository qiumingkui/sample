package com.qiumingkui.sample.imedia.common.ext.id;

import java.io.Serializable;

public interface Identity<T extends Identity<?>> extends Serializable {

	public boolean equals(T id);
}
