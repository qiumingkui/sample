package com.qiumingkui.sample.imedia.blog.domain.model.category;

import com.qiumingkui.sample.imedia.common.ext.util.UUIDUtil;

public class CategoryFactory {

	public static Category create(String aParentId, String aName, String aDescription) {

		final String CATEGORY_ID = UUIDUtil.gen();
		final long POST_NUMBER = 0;

		Category category = new Category(new CategoryId(CATEGORY_ID), new CategoryId(aParentId), aName, aDescription,
				new CategoryVal(POST_NUMBER));
		return category;
	}

}
