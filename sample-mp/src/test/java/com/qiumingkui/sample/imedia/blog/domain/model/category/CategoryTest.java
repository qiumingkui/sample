package com.qiumingkui.sample.imedia.blog.domain.model.category;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiumingkui.sample.imedia.blog.domain.model.category.Category;
import com.qiumingkui.sample.imedia.blog.helper.CategoryTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest {

	@Test
	public void changeDescription() {
		Category category = CategoryTestHelper.buildCategoryExample();
		String description = "Description:"+new Date();
		category.changeDescription(description);
		assertTrue(category.description().equals(description));
	}
}
