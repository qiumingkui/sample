package com.qiumingkui.sample.imedia.blog.domain.model.category;

import com.qiumingkui.sample.imedia.common.ext.policy.PolicyDecisionResult;
import com.qiumingkui.sample.imedia.makemoney.domain.model.member.Admin;

public class CategoryPermissionPolicy {

	public static PolicyDecisionResult hasAddCategoryPermission(Admin admin) {
		
		if(admin!=null&&admin.isValidated()){
			PolicyDecisionResult result = new PolicyDecisionResult(true);
			return result;
		}
		
		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;

	}
	
	public static PolicyDecisionResult hasChangeDescriptionPermission(Admin admin) {
		
		if(admin!=null&&admin.isValidated()){
			PolicyDecisionResult result = new PolicyDecisionResult(true);
			return result;
		}
		
		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;
	}
	
	public static PolicyDecisionResult hasChangePostNumberPermission(Admin admin) {
		
		if(admin!=null&&admin.isValidated()){
			PolicyDecisionResult result = new PolicyDecisionResult(true);
			return result;
		}
		
		PolicyDecisionResult result = new PolicyDecisionResult(false);
		return result;

	}
	
}
