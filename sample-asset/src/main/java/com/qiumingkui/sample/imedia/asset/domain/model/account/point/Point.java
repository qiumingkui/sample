package com.qiumingkui.sample.imedia.asset.domain.model.account.point;

import java.io.Serializable;

public class Point implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String CurrencyUnit = "cents";

	private long number = 0;

	private Point() {
		super();
	}

	public Point(long number) {
		super();
		this.number = number;
	}

	/**
	 * @return the currencyunit
	 */
	public static String currencyunit() {
		return CurrencyUnit;
	}

	/**
	 * @return the number
	 */
	public long number() {
		return number;
	}

}
