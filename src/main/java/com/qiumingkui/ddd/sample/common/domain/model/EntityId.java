package com.qiumingkui.ddd.sample.common.domain.model;

import java.io.Serializable;

public class EntityId implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;

	public EntityId(){
		super();
	}
	
	public EntityId(String id) {
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
