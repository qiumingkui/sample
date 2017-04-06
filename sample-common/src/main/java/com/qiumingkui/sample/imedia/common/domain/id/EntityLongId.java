package com.qiumingkui.sample.imedia.common.domain.id;

public class EntityLongId implements DomainEntityId<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Long id;

	public EntityLongId() {
		super();
	}

	public EntityLongId(Long aId) {
		super();
		setId(aId);
	}

	public Long id() {
		return this.id;
	}

	private void setId(Long aId) {
		this.id = aId;
	}
	
}
