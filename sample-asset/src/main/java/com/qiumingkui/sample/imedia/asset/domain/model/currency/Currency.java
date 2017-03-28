package com.qiumingkui.sample.imedia.asset.domain.model.currency;

import java.io.Serializable;

public interface Currency extends Serializable {

	public String currencyUnit();
	
	public long number();
}
