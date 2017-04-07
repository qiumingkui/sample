package com.qiumingkui.sample.imedia.mp.domain.model.category;

import com.qiumingkui.sample.imedia.common.util.UUIDUtils;

public class CategoryFactory {

	public static Category create(String aParentId, String aName, String aDescription) {
		
		final String CATEGORY_ID = UUIDUtils.gen();
		final long POST_NUMBER = 0;

		Category category = new Category().create(new CategoryId(CATEGORY_ID), new CategoryId(aParentId), aName, aDescription,
				new CategoryPostVal(POST_NUMBER));
		return category;
	}

}
