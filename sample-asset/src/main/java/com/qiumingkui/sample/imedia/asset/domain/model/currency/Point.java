package com.qiumingkui.sample.imedia.asset.domain.model.currency;

public class Point implements Currency {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String currencyUnit = "CENT";

	private long number = 0;

	private Point() {
		super();
	}

	public Point(long number) {
		this();
		this.number = number;
	}

	/**
	 * @return the currencyUnit
	 */
	public String currencyUnit() {
		return this.currencyUnit;
	}

	/**
	 * @return the number
	 */
	public long number() {
		return number;
	}

}
