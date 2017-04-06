package com.qiumingkui.sample.imedia.common.domain.id;

public class EntityStrId implements DomainEntityId<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String id;

	public EntityStrId() {
		super();
	}

	public EntityStrId(String id) {
		super();
		setId(id);
	}

	public String id() {
		return this.id;
	}

	private void setId(String id) {
		this.id = id;
	}
	
}
