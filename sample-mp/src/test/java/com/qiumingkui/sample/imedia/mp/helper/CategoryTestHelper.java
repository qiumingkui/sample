package com.qiumingkui.sample.imedia.mp.helper;

import com.qiumingkui.sample.imedia.mp.domain.model.category.Category;
import com.qiumingkui.sample.imedia.mp.domain.model.category.CategoryFactory;

public class CategoryTestHelper {

	public static Category buildCategoryExample(){
		
		Category category = CategoryFactory.create("1", "Name", "Description");
		
		return category ;
	}
}
