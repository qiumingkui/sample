package com.qiumingkui.sample.imedia.common.domain.policy;

public class PolicyDecisionResult {

	private boolean permit;
	
	private String message;

	private PolicyDecisionResult() {
		super();
	}
	
	public PolicyDecisionResult(boolean aPermit){
		this(aPermit,"This permit: "+aPermit);
	}
	
	public PolicyDecisionResult(boolean aPermit, String aMessage) {
		this();
		this.permit = aPermit;
		this.message = aMessage;
	}

	public boolean isPermit() {
		return permit;
	}

	public String message() {
		return message;
	}
	
	
}
