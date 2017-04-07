package com.qiumingkui.sample.imedia.blog.helper;

import com.qiumingkui.sample.imedia.blog.domain.model.category.Category;
import com.qiumingkui.sample.imedia.blog.domain.model.category.CategoryFactory;

public class CategoryTestHelper {

	public static Category buildCategoryExample(){
		
		Category category = CategoryFactory.create("1", "Name", "Description");
		
		return category ;
	}
}
