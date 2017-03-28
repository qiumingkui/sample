package com.qiumingkui.sample.imedia.asset.domain.model.currency;

public class Rmb implements Currency{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String currencyUnit = "YUN";

	private long number = 0;
	
	private Rmb() {
		super();
	}
	
	public Rmb(long aNumber) {
		this();
		this.number = aNumber;
	}

	/**
	 * @return the currencyUnit
	 */
	@Override
	public String currencyUnit() {
		return this.currencyUnit;
	}

	/**
	 * @return the number
	 */
	@Override
	public long number() {
		return number;
	}


}
