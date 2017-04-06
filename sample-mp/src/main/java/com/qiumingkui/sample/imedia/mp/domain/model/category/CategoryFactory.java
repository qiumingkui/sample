package com.qiumingkui.sample.imedia.mp.domain.model.category;

import com.qiumingkui.sample.imedia.common.util.UUIDUtils;

public class CategoryFactory {

	public static Category create(String aParentId, String aName, String aDescription) {
		final String CATEGORY_ID = UUIDUtils.gen();
		Category category = new Category(new CategoryId(CATEGORY_ID), new CategoryId(aParentId), aName, aDescription,
				new CategoryPostVal(0));
		return category;	
	}

}
